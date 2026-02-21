package com.molti.app.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChatMessage(
    val id: String = "",
    val content: String = "",
    val isFromUser: Boolean = true,
    val timestamp: Long = System.currentTimeMillis()
) : Parcelable

@Parcelize
data class Task(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false,
    val priority: Priority = Priority.MEDIUM,
    val dueDate: Long? = null,
    val createdAt: Long = System.currentTimeMillis()
) : Parcelable

enum class Priority {
    LOW, MEDIUM, HIGH
}

@Parcelize
data class Note(
    val id: String = "",
    val title: String = "",
    val content: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) : Parcelable

@Parcelize
data class CalendarEvent(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val startTime: Long = 0,
    val endTime: Long = 0,
    val location: String = "",
    val isAllDay: Boolean = false
) : Parcelable

data class UserPreferences(
    val darkMode: Boolean = false,
    val notificationsEnabled: Boolean = true,
    val username: String = "User",
    val apiKey: String = ""
)
