package com.greyhairredbear.racooin.core.model

enum class CryptoCurrency {
    BITCOIN,
    ETHEREUM,
    DOGECOIN,
    LITECOIN,
    RIPPLE,
}

enum class FiatCurrency {
    EURO,
    US_DOLLAR,
}

data class CryptoBalance(val cryptoCurrency: CryptoCurrency, val balance: Double)

data class FiatBalance(val fiatCurrency: FiatCurrency, val balance: Double)

data class CryptoCurrencyRate(val cryptoCurrency: CryptoCurrency, val fiatBalance: FiatBalance)

data class CryptoFiatBalance(val cryptoBalance: CryptoBalance, val fiatBalance: FiatBalance)
