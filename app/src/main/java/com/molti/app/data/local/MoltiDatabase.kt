package com.molti.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.molti.app.data.local.dao.ChatDao
import com.molti.app.data.local.dao.TaskDao
import com.molti.app.data.local.dao.NoteDao
import com.molti.app.data.local.entity.ChatMessageEntity
import com.molti.app.data.local.entity.TaskEntity
import com.molti.app.data.local.entity.NoteEntity

@Database(
    entities = [
        ChatMessageEntity::class,
        TaskEntity::class,
        NoteEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MoltiDatabase : RoomDatabase() {
    abstract fun chatDao(): ChatDao
    abstract fun taskDao(): TaskDao
    abstract fun noteDao(): NoteDao
}
