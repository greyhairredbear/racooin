package com.greyhairredbear.racooin.core.businesslogic

import arrow.core.Either
import arrow.core.None
import arrow.core.computations.either
import arrow.core.flatMap
import arrow.core.left
import arrow.core.right
import arrow.core.traverseEither
import com.greyhairredbear.racooin.core.model.ComputationFailedError
import com.greyhairredbear.racooin.core.model.CryptoBalance
import com.greyhairredbear.racooin.core.model.CryptoCurrencyRate
import com.greyhairredbear.racooin.core.model.FiatBalance

// TODO
//  test
//  error modelling
fun CryptoBalance.toFiatBalance(rate: CryptoCurrencyRate): Either<ComputationFailedError, FiatBalance> {
    return when {
        cryptoCurrency != rate.cryptoCurrency -> ComputationFailedError.left()
        else -> rate.fiatBalance.copy(balance = balance * rate.fiatBalance.balance).right()
    }
}

// TODO: support multiple rates
fun List<CryptoBalance>.toFiatBalances(rates: List<CryptoCurrencyRate>): Either<ComputationFailedError, List<FiatBalance>> =
    traverseEither { balance ->
        balance.toFiatBalance(
            rates.firstOrNull { it.cryptoCurrency == balance.cryptoCurrency }
                ?: return ComputationFailedError.left()
        )
    }
