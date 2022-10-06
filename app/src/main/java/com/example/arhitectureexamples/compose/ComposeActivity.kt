package com.example.arhitectureexamples.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComposeActivity : AppCompatActivity() {

    private val viewModel: ComposeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val scaffoldState = rememberScaffoldState()
            Scaffold(
                scaffoldState = scaffoldState,
                content = { MainScreen(viewModel, scaffoldState) },
                snackbarHost = { host ->
                    SnackbarHost(host) {
                        Snackbar(it)
                    }
                }

            )
        }
    }
}

@Composable
fun MainScreen(
    viewModel: ComposeViewModel,
    scaffoldState: ScaffoldState
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onIntent(Intent.Init)
        viewModel.effect.collect {
            scaffoldState.snackbarHostState.showSnackbar("Generic message")
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (viewModel.state) {
            is State.Content -> Text(
                text = (viewModel.state as State.Content).data,
                modifier = Modifier.clickable {
                    viewModel.onIntent(Intent.ShowGenericMessage)
                }
            )
            State.Loading -> CircularProgressIndicator()
        }
    }
}
