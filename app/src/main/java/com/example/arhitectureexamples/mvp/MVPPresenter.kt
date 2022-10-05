package com.example.arhitectureexamples.mvp

import com.example.arhitectureexamples.core.usecase.GetSomeData
import com.example.arhitectureexamples.mvp.base.Contract
import kotlinx.coroutines.launch

class MVPPresenter(
    private val view: Contract.View,
    private val getSomeData: GetSomeData
) : Contract.Presenter {

    override fun initLoad() {
        view.scope().launch {
            view.showData(getSomeData.invoke())
        }
    }
}
