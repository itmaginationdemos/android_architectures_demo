package com.example.arhitectureexamples.mvi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arhitectureexamples.core.usecase.GetSomeDataImpl
import com.example.arhitectureexamples.mvi.Intent.*
import kotlinx.coroutines.launch

class MVIViewModel(
    val getSomeData: GetSomeDataImpl
) : ViewModel(), OnIntent {

    val state = MutableLiveData<MVIState>(MVIState.Loading)
    val effect = MutableLiveData<ViewEffect>()

    override fun onIntent(intent: Intent) {
        viewModelScope.launch {
            when (intent) {
                Init -> state.postValue(MVIState.Content(getSomeData()))
                ShowGenericMessage -> effect.postValue(ViewEffect.ShowGenericMessage)
            }
        }
    }
}
