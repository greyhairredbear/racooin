package com.greyhairredbear.racooin.core.usecase

import arrow.core.Either
import arrow.core.computations.either
import com.greyhairredbear.racooin.core.interfaces.ApiClient
import com.greyhairredbear.racooin.core.interfaces.Persistence
import com.greyhairredbear.racooin.core.model.CryptoCurrency
import com.greyhairredbear.racooin.core.model.CryptoBalance

sealed class UsecaseError
object GeneralUseCaseError: UsecaseError()

suspend fun calculateBalances(
    apiClient: ApiClient,
    persistence: Persistence,
): Either<UsecaseError, List<CryptoBalance>> =
    either {
        val rates = apiClient.fetchCurrencyRates().mapLeft { GeneralUseCaseError }.bind()
        // TODO
        val cryptoBalances = persistence.fetchCryptoBalance(CryptoCurrency.BITCOIN)

        listOf()
    }
