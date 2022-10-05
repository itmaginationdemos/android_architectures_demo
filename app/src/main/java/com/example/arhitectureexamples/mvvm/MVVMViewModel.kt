package com.example.arhitectureexamples.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arhitectureexamples.core.usecase.GetSomeData
import kotlinx.coroutines.launch

class MVVMViewModel(
    val getSomeData: GetSomeData
) : ViewModel() {

    val data = MutableLiveData(MVVMState())

    init {
        viewModelScope.launch {
            val res = getSomeData()
            data.value = data.value!!.copy(
                isLoading = false,
                data = res
            )
        }
    }
}
