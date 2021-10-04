package com.greyhairredbear.racooin.core.interfaces

import com.greyhairredbear.racooin.core.model.CryptoCurrencyBalance

interface Persistence {
    fun persistCurrencyBalance(balance: CryptoCurrencyBalance)
    fun persistCurrencyInvest()
}
