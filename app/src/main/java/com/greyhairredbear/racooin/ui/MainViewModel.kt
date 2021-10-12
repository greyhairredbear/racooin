package com.greyhairredbear.racooin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.computations.either
import com.greyhairredbear.racooin.core.interfaces.ApiClient
import com.greyhairredbear.racooin.core.interfaces.Persistence
import com.greyhairredbear.racooin.core.interfaces.Resource
import com.greyhairredbear.racooin.core.model.ApiClientError
import com.greyhairredbear.racooin.core.model.CryptoCurrencyRate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


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
