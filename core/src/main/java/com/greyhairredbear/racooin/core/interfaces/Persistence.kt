package com.greyhairredbear.racooin.core.interfaces

import com.greyhairredbear.racooin.core.model.CryptoCurrency
import com.greyhairredbear.racooin.core.model.CryptoBalance
import com.greyhairredbear.racooin.core.model.FiatBalance

// TODO model with either
interface Persistence {
    fun persistCryptoBalance(balance: CryptoBalance)
    fun fetchCryptoBalance(currency: CryptoCurrency): CryptoBalance

    fun persistInvest(currency: CryptoCurrency, balance: FiatBalance)
    fun fetchInvest(currency: CryptoCurrency): FiatBalance
}
