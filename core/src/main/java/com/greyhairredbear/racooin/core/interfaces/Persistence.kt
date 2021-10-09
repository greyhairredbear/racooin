package com.greyhairredbear.racooin.core.interfaces

import com.greyhairredbear.racooin.core.model.CryptoCurrency
import com.greyhairredbear.racooin.core.model.CryptoBalance
import com.greyhairredbear.racooin.core.model.CryptoCurrencyRate
import com.greyhairredbear.racooin.core.model.FiatBalance

// TODO model with either
interface Persistence {
    suspend fun persistCryptoBalance(balance: CryptoBalance): Unit
    suspend fun fetchCryptoBalance(currency: CryptoCurrency): CryptoBalance

    suspend fun persistInvest(currency: CryptoCurrency, balance: FiatBalance): Unit
    suspend fun fetchInvest(currency: CryptoCurrency): FiatBalance

    suspend fun persistCurrencyRates(rates: List<CryptoCurrencyRate>): Unit
    suspend fun fetchCurrencyRates(): List<CryptoCurrencyRate>
}
