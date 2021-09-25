package com.greyhairredbear.racooin.core

import arrow.core.Either

sealed class ApiClientError {
    class ApiCallFailed : ApiClientError()
}

data class CurrencyRate(
    val currency: String, // TODO: refactor to enum?
    val rate: Double
)

interface ApiClient {
    suspend fun fetchCurrencyRates(): Either<ApiClientError, List<CurrencyRate>>
}
