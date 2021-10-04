package com.greyhairredbear.racooin.core.interfaces

import arrow.core.Either
import com.greyhairredbear.racooin.core.model.CurrencyRate

sealed class ApiClientError
object ApiCallFailed : ApiClientError()

interface ApiClient {
    suspend fun fetchCurrencyRates(): Either<ApiClientError, List<CurrencyRate>>
}
