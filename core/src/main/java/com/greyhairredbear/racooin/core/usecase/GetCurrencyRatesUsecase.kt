package com.greyhairredbear.racooin.core.usecase

import arrow.core.Either
import arrow.core.computations.either
import com.greyhairredbear.racooin.core.interfaces.ApiClient
import com.greyhairredbear.racooin.core.interfaces.Persistence
import com.greyhairredbear.racooin.core.model.CryptoCurrencyRate
import com.greyhairredbear.racooin.core.model.UsecaseError

suspend fun getCurrencyRates(
    apiClient: ApiClient,
    persistence: Persistence,
): Either<UsecaseError, List<CryptoCurrencyRate>>  = either {
    // TODO
    //  fetch from persistence, check timestamp
    //  timestamp longer than 1h ago -> reloadCurrenciesUsecase
    //  return
    listOf()
}
