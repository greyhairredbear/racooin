package com.greyhairredbear.racooin.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.greyhairredbear.racooin.core.interfaces.Resource
import com.greyhairredbear.racooin.core.model.CryptoCurrencyRate

@Composable
fun MainScreen(
    screenViewModel: MainViewModel = viewModel()
) {
    val uiState by screenViewModel.uiState.collectAsState()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        when (uiState) {
            is Resource.Success -> {
                (uiState as Resource.Success).data.forEach {
                    Text(text = "1 ${it.cryptoCurrency.name} = ${it.fiatBalance.balance} ${it.fiatBalance.fiatCurrency}")
                }
            }
            is Resource.Error -> {
                Text(text = "Error")
            }
            is Resource.Loading -> {
                Text(text = "Loading")
            }
        }
    }
}
