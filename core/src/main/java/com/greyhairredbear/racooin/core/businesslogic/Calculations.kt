package com.greyhairredbear.racooin.core.businesslogic

import arrow.core.Either
import arrow.core.None
import arrow.core.computations.either
import arrow.core.flatMap
import arrow.core.left
import arrow.core.right
import com.greyhairredbear.racooin.core.model.ComputationFailedError
import com.greyhairredbear.racooin.core.model.CryptoBalance
import com.greyhairredbear.racooin.core.model.CryptoCurrencyRate
import com.greyhairredbear.racooin.core.model.FiatBalance

// TODO
//  test
//  error vs none
fun CryptoBalance.toFiatBalance(rate: CryptoCurrencyRate): Either<None, FiatBalance> {
    return when {
        cryptoCurrency != rate.cryptoCurrency -> None.left()
        else -> rate.fiatBalance.copy(balance = balance * rate.fiatBalance.balance).right()
    }
}

fun List<CryptoBalance>.toFiatBalances(rates: List<CryptoCurrencyRate>): Either<ComputationFailedError, List<FiatBalance>> {
    return listOf<FiatBalance>().right() // TODO
//    return map { cryptoBalance ->
//            cryptoBalance.toFiatBalance(rates.first { it.cryptoCurrency == cryptoBalance.cryptoCurrency }) // TODO catch first exception
//                .mapLeft { ComputationFailedError }
//    }.right()
}
