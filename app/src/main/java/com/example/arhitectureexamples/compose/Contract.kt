package com.example.arhitectureexamples.compose

interface OnIntent {
    fun onIntent(intent: Intent)
}

sealed interface Intent {
    object Init : Intent
    object ShowGenericMessage : Intent
}

sealed interface ViewEffect {
    object ShowGenericMessage : ViewEffect
}

sealed class State {
    object Loading : State()
    data class Content(
        val data: String
    ) : State()
}
