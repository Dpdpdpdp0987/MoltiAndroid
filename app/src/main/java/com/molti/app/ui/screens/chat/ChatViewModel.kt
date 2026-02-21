package com.molti.app.ui.screens.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.molti.app.data.repository.ChatRepository
import com.molti.app.domain.model.ChatMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val chatRepository: ChatRepository
) : ViewModel() {
    
    val messages: StateFlow<List<ChatMessage>> = chatRepository.getAllMessages()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    
    fun sendMessage(content: String) {
        viewModelScope.launch {
            // Add user message
            chatRepository.sendMessage(content, isFromUser = true)
            
            // Simulate AI response (in real app, call AI API here)
            val aiResponse = generateAIResponse(content)
            chatRepository.sendMessage(aiResponse, isFromUser = false)
        }
    }
    
    private fun generateAIResponse(userMessage: String): String {
        val lowercaseMsg = userMessage.lowercase()
        
        return when {
            lowercaseMsg.contains("hallo") || lowercaseMsg.contains("hi") -> 
                "Hallo! 🐙 Wie kann ich dir helfen?"
            lowercaseMsg.contains("aufgabe") || lowercaseMsg.contains("todo") ->
                "Möchtest du eine neue Aufgabe erstellen? Sag mir einfach den Titel!"
            lowercaseMsg.contains("termin") || lowercaseMsg.contains("kalender") ->
                "Ich kann dir bei deinem Kalender helfen. Was möchtest du planen?"
            lowercaseMsg.contains("hilfe") ->
                "Ich kann dir bei vielen Dingen helfen: Aufgaben, Termine, Notizen, oder einfach nur plaudern. Was brauchst du?"
            else ->
                "Verstanden! 🐙 Sag mir mehr darüber, wie ich dir helfen kann."
        }
    }
    
    fun clearChat() {
        viewModelScope.launch {
            chatRepository.clearMessages()
        }
    }
}
