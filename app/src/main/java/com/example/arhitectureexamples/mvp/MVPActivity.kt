package com.example.arhitectureexamples.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.arhitectureexamples.databinding.ActivityGenericLayoutBinding
import com.example.arhitectureexamples.mvp.base.Contract
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MVPActivity : AppCompatActivity(), Contract.View {

    private lateinit var binding: ActivityGenericLayoutBinding
    private val presenter: Contract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenericLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.initLoad()
    }

    override fun scope(): LifecycleCoroutineScope {
        return lifecycleScope
    }

    override fun showData(data: String) {
        with(binding) {
            loadingPb.isVisible = false
            resultTv.isVisible = true
            resultTv.text = data
        }
    }
}
