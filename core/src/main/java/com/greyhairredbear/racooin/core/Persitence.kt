package com.greyhairredbear.racooin.core

import com.greyhairredbear.racooin.core.model.CurrencyBalance

interface Persitence {
    fun persistCurrencyBalance(currencyBalance: CurrencyBalance)
}
