package com.example.arhitectureexamples.mvi

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

sealed class MVIState {
    object Loading : MVIState()
    data class Content(
        val data: String
    ) : MVIState()
}
