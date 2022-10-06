package com.example.arhitectureexamples.mvi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.arhitectureexamples.databinding.ActivityGenericLayoutBinding
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_LONG
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MVIActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGenericLayoutBinding
    private val viewModel: MVIViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenericLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.effect.observe(this) { showEffect(it) }
        viewModel.state.observe(this) { render(it) }

        viewModel.onIntent(Intent.Init)

        binding.resultTv.setOnClickListener {
            viewModel.onIntent(Intent.ShowGenericMessage)
        }
    }

    private fun render(state: MVIState) {
        with(binding) {
            when (state) {
                is MVIState.Content -> {
                    loadingPb.isVisible = false
                    resultTv.isVisible = true
                    resultTv.text = state.data
                }
                MVIState.Loading -> {
                    loadingPb.isVisible = true
                    resultTv.isVisible = false
                }
            }
        }
    }

    private fun showEffect(effect: ViewEffect) {
        when (effect) {
            ViewEffect.ShowGenericMessage ->
                Snackbar.make(binding.root, "Generic msg", LENGTH_LONG).show()
        }
    }
}
