package com.greyhairredbear.racooin.core.usecase

import arrow.core.Either
import arrow.core.computations.either
import com.greyhairredbear.racooin.core.businesslogic.toFiatBalances
import com.greyhairredbear.racooin.core.interfaces.ApiClient
import com.greyhairredbear.racooin.core.interfaces.Persistence
import com.greyhairredbear.racooin.core.model.FiatBalance
import com.greyhairredbear.racooin.core.model.UsecaseError


suspend fun calculateBalances(
    apiClient: ApiClient,
    persistence: Persistence,
): Either<UsecaseError, List<FiatBalance>> =
    either {
        val rates = getCurrencyRates(
            { persistence.fetchCurrencyRates() },
            { apiClient.fetchCurrencyRates() },
            { persistence.persistCurrencyRates(it) }
        ).bind()
        val cryptoBalances = persistence.fetchAllCryptoBalances().bind()
        val result = cryptoBalances.toFiatBalances(rates).bind()
        result
    }
