package com.greyhairredbear.racooin.persistence

import com.greyhairredbear.racooin.core.interfaces.Persistence
import com.greyhairredbear.racooin.core.model.CryptoBalance
import com.greyhairredbear.racooin.core.model.CryptoCurrency
import com.greyhairredbear.racooin.core.model.FiatBalance

class DataStorePersistence : Persistence {
    override fun persistCryptoBalance(balance: CryptoBalance) {
        TODO("Not yet implemented")
    }

    override fun fetchCryptoBalance(currency: CryptoCurrency): CryptoBalance {
        TODO("Not yet implemented")
    }


    override fun persistInvest(currency: CryptoCurrency, balance: FiatBalance) {
        TODO("Not yet implemented")
    }

    override fun fetchInvest(currency: CryptoCurrency): FiatBalance {
        TODO("Not yet implemented")
    }

}
