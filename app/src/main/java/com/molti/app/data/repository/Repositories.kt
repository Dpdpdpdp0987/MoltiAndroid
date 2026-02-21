package com.molti.app.data.repository

import com.molti.app.data.local.dao.ChatDao
import com.molti.app.data.local.dao.TaskDao
import com.molti.app.data.local.dao.NoteDao
import com.molti.app.data.local.entity.ChatMessageEntity
import com.molti.app.data.local.entity.TaskEntity
import com.molti.app.data.local.entity.NoteEntity
import com.molti.app.domain.model.ChatMessage
import com.molti.app.domain.model.Task
import com.molti.app.domain.model.Note
import com.molti.app.domain.model.Priority
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRepository @Inject constructor(
    private val chatDao: ChatDao
) {
    fun getAllMessages(): Flow<List<ChatMessage>> {
        return chatDao.getAllMessages().map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    suspend fun sendMessage(content: String, isFromUser: Boolean = true) {
        val message = ChatMessageEntity(
            id = UUID.randomUUID().toString(),
            content = content,
            isFromUser = isFromUser,
            timestamp = System.currentTimeMillis()
        )
        chatDao.insertMessage(message)
    }
    
    suspend fun clearMessages() {
        chatDao.clearMessages()
    }
    
    private fun ChatMessageEntity.toDomain() = ChatMessage(
        id = id,
        content = content,
        isFromUser = isFromUser,
        timestamp = timestamp
    )
}

@Singleton
class TaskRepository @Inject constructor(
    private val taskDao: TaskDao
) {
    fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks().map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    fun getPendingTasks(): Flow<List<Task>> {
        return taskDao.getPendingTasks().map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    suspend fun addTask(title: String, description: String = "", priority: Priority = Priority.MEDIUM) {
        val task = TaskEntity(
            id = UUID.randomUUID().toString(),
            title = title,
            description = description,
            isCompleted = false,
            priority = priority.name,
            dueDate = null,
            createdAt = System.currentTimeMillis()
        )
        taskDao.insertTask(task)
    }
    
    suspend fun toggleTaskCompletion(task: Task) {
        taskDao.updateTask(task.toEntity().copy(isCompleted = !task.isCompleted))
    }
    
    suspend fun deleteTask(taskId: String) {
        taskDao.deleteTaskById(taskId)
    }
    
    private fun TaskEntity.toDomain() = Task(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
        priority = Priority.valueOf(priority),
        dueDate = dueDate,
        createdAt = createdAt
    )
    
    private fun Task.toEntity() = TaskEntity(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
        priority = priority.name,
        dueDate = dueDate,
        createdAt = createdAt
    )
}

@Singleton
class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {
    fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes().map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    suspend fun addNote(title: String, content: String) {
        val note = NoteEntity(
            id = UUID.randomUUID().toString(),
            title = title,
            content = content,
            createdAt = System.currentTimeMillis(),
            updatedAt = System.currentTimeMillis()
        )
        noteDao.insertNote(note)
    }
    
    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note.toEntity().copy(updatedAt = System.currentTimeMillis()))
    }
    
    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toEntity())
    }
    
    private fun NoteEntity.toDomain() = Note(
        id = id,
        title = title,
        content = content,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
    
    private fun Note.toEntity() = NoteEntity(
        id = id,
        title = title,
        content = content,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
