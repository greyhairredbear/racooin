package com.greyhairredbear.racooin

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import arrow.core.computations.either
import com.greyhairredbear.racooin.apiclient.CoingeckoApiClient
import com.greyhairredbear.racooin.core.interfaces.ApiClient
import com.greyhairredbear.racooin.core.interfaces.ApiClientError
import com.greyhairredbear.racooin.core.interfaces.Persistence
import com.greyhairredbear.racooin.core.interfaces.Resource
import com.greyhairredbear.racooin.core.model.CryptoCurrencyRate
import com.greyhairredbear.racooin.persistence.CryptoBalances
import com.greyhairredbear.racooin.persistence.Invests
import com.greyhairredbear.racooin.persistence.serializer.CryptoBalanceSerializer
import com.greyhairredbear.racooin.persistence.serializer.InvestSerializer
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }

        lifecycleScope.launchWhenResumed {
            withContext(Dispatchers.IO) {
                val ignored = ""
                println(ignored)
            }
        }
    }
}

@Composable
private fun MainScreen(
    screenViewModel: MainViewModel = viewModel()
) {
    val uiState by screenViewModel.uiState.collectAsState()
    when (uiState) {
        is Resource.Success -> {
            Text(text = "Success")
        }
        is Resource.Error -> {
            Text(text = "Error")
        }
        is Resource.Loading -> {
            Text(text = "Loading")
        }
    }
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiClient: ApiClient,
    private val persistence: Persistence,
) : ViewModel() {
    private val _uiState = MutableStateFlow<Resource<List<CryptoCurrencyRate>>>(Resource.Loading)
    val uiState: StateFlow<Resource<List<CryptoCurrencyRate>>> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val test = either<ApiClientError, List<CryptoCurrencyRate>> {
                val currencyRateResult = apiClient.fetchCurrencyRates().bind()
                currencyRateResult
            }

            test.fold(
                ifRight = { _uiState.value = Resource.Success(it) },
                ifLeft = { _uiState.value = Resource.Error("failed api call") },
            )
        }
    }
}

private const val DATA_STORE_FILENAME_BALANCES = "balances.pb"

private val Context.cryptoBalancesStore: DataStore<CryptoBalances> by dataStore(
    fileName = DATA_STORE_FILENAME_BALANCES,
    serializer = CryptoBalanceSerializer
)

private const val DATA_STORE_FILENAME_INVESTS = "invests.pb"

private val Context.investsStore: DataStore<Invests> by dataStore(
    fileName = DATA_STORE_FILENAME_INVESTS,
    serializer = InvestSerializer
)
