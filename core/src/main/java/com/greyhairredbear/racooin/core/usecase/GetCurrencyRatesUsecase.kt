package com.greyhairredbear.racooin.core.usecase

import arrow.core.Either
import arrow.core.computations.either
import com.greyhairredbear.racooin.core.model.ApiClientError
import com.greyhairredbear.racooin.core.model.CryptoCurrencyRate
import com.greyhairredbear.racooin.core.model.PersistenceError
import com.greyhairredbear.racooin.core.model.UsecaseError

suspend fun getCurrencyRates(
    fetchRatesFromDb: suspend () -> Either<PersistenceError, List<CryptoCurrencyRate>>,
    fetchRatesFromApi: suspend () -> Either<ApiClientError, List<CryptoCurrencyRate>>,
    persistRates: suspend (List<CryptoCurrencyRate>) -> Either<PersistenceError, Unit>,
): Either<UsecaseError, List<CryptoCurrencyRate>> = either {
    val rates = fetchRatesFromApi().bind()
    val persistRatesResultIgnored = persistRates(rates).bind()
    val result = fetchRatesFromDb().bind()
    // TODO
    //  fetch from persistence before api call, check timestamp
    //  timestamp longer than 1h ago -> reloadCurrenciesUsecase
    result
}
