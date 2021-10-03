package com.greyhairredbear.racooin.core.model

enum class CryptoCurrency {
    BITCOIN,
    ETHEREUM,
    DOGE,
    LITECOIN,
    RIPPLE,
}

enum class FiatCurrency {
    EURO,
    US_DOLLAR,
}

data class CryptoCurrencyBalance(val cryptoCurrency: CryptoCurrency, val balance: Double)
data class FiatBalance(val fiatCurrency: FiatCurrency, val balance: Double)
data class CurrencyRate(val cryptoCurrency: CryptoCurrency, val fiatBalance: FiatBalance)
