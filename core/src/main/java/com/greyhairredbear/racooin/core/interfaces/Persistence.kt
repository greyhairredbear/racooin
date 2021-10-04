package com.greyhairredbear.racooin.core.interfaces

import com.greyhairredbear.racooin.core.model.CryptoCurrency
import com.greyhairredbear.racooin.core.model.CryptoBalance
import com.greyhairredbear.racooin.core.model.FiatBalance

// TODO model with either
interface Persistence {
    fun persistCurrencyBalance(balance: CryptoBalance)
    fun fetchCurrencyBalance(currency: CryptoCurrency): CryptoBalance

    fun persistCurrencyInvest(currency: CryptoCurrency, balance: FiatBalance)
    fun fetchCurrencyInvest(currency: CryptoCurrency): FiatBalance
}
