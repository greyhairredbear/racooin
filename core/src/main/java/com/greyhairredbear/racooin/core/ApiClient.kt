package com.greyhairredbear.racooin.core

import arrow.core.Either
import com.greyhairredbear.racooin.core.model.CurrencyRate

sealed class ApiClientError
object ApiCallFailed : ApiClientError()

//data class CurrencyRate(
//    val currency: String, // TODO: refactor to enum?
//    val rate: Double
//)

interface ApiClient {
    suspend fun fetchCurrencyRates(): Either<ApiClientError, List<CurrencyRate>>
}
