package com.greyhairredbear.racooin.core.interfaces

import arrow.core.Either
import com.greyhairredbear.racooin.core.model.ApiClientError
import com.greyhairredbear.racooin.core.model.CryptoCurrencyRate

interface ApiClient {
    suspend fun fetchCurrencyRates(): Either<ApiClientError, List<CryptoCurrencyRate>>
}
