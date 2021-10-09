package com.greyhairredbear.racooin.core.usecase

import arrow.core.Either
import arrow.core.computations.either
import com.greyhairredbear.racooin.core.interfaces.ApiClient
import com.greyhairredbear.racooin.core.interfaces.Persistence
import com.greyhairredbear.racooin.core.model.CryptoBalance
import com.greyhairredbear.racooin.core.model.UsecaseError


suspend fun calculateBalances(
    apiClient: ApiClient,
    persistence: Persistence,
): Either<UsecaseError, List<CryptoBalance>> =
    either {
        val rates = getCurrencyRates(apiClient, persistence).bind()
        val cryptoBalances = persistence.fetchAllCryptoBalances().bind()

        // TODO: calc

        listOf()
    }
