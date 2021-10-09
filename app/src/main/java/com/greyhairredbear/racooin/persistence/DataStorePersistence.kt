package com.greyhairredbear.racooin.persistence

import com.greyhairredbear.racooin.core.interfaces.Persistence
import com.greyhairredbear.racooin.core.model.CryptoBalance
import com.greyhairredbear.racooin.core.model.CryptoCurrency
import com.greyhairredbear.racooin.core.model.CryptoCurrencyRate
import com.greyhairredbear.racooin.core.model.FiatBalance

class DataStorePersistence : Persistence {
    override suspend fun persistCryptoBalance(balance: CryptoBalance) {
        TODO("Not yet implemented")
    }

    override suspend fun fetchCryptoBalance(currency: CryptoCurrency): CryptoBalance {
        TODO("Not yet implemented")
    }


    override suspend fun persistInvest(currency: CryptoCurrency, balance: FiatBalance) {
        TODO("Not yet implemented")
    }

    override suspend fun fetchInvest(currency: CryptoCurrency): FiatBalance {
        TODO("Not yet implemented")
    }

    override suspend fun persistCurrencyRates(rates: List<CryptoCurrencyRate>) {
        TODO("Not yet implemented")
    }

    override suspend fun fetchCurrencyRates(): List<CryptoCurrencyRate> {
        TODO("Not yet implemented")
    }

}
