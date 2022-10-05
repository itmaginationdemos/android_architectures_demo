package com.example.arhitectureexamples.mvp.base

import androidx.lifecycle.LifecycleCoroutineScope

interface Contract {

    interface View {
        fun scope(): LifecycleCoroutineScope
        fun showData(data: String)
    }

    interface Presenter {
        fun initLoad()
    }
}
