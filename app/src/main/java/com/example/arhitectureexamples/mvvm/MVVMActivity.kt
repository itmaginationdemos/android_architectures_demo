package com.example.arhitectureexamples.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.arhitectureexamples.databinding.ActivityGenericLayoutBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MVVMActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGenericLayoutBinding
    private val viewModel: MVVMViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenericLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.data.observe(this) {
            render(it)
        }
    }

    private fun render(state: MVVMState) {
        with(binding) {
            loadingPb.isVisible = state.isLoading
            resultTv.isVisible = !state.isLoading
            resultTv.text = state.data
        }
    }
}
