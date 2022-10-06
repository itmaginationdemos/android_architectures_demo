package com.example.arhitectureexamples.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arhitectureexamples.core.usecase.GetSomeDataImpl
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class ComposeViewModel(
    val getSomeData: GetSomeDataImpl
) : ViewModel(), OnIntent {

    var state: State by mutableStateOf(State.Loading)
    val effect = MutableSharedFlow<ViewEffect>()

    override fun onIntent(intent: Intent) {
        viewModelScope.launch {
            when (intent) {
                Intent.Init -> state = State.Content(getSomeData())
                Intent.ShowGenericMessage -> effect.emit(ViewEffect.ShowGenericMessage)
            }
        }
    }
}
