package com.greyhairredbear.racooin.apiclient

import com.greyhairredbear.racooin.core.model.CryptoCurrency
import com.greyhairredbear.racooin.core.model.CryptoCurrencyRate
import com.greyhairredbear.racooin.core.model.FiatCurrency
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize

val sut = CoingeckoApiClient()

class ApiClientTest : FunSpec({
    test("should fetch currencies from api") {
        val result = sut.fetchCurrencyRates()
            .shouldBeRight()

        result.shouldHaveSize(10)
        result.shouldContainAllCurrencyCombinations()
    }
})

private fun List<CryptoCurrencyRate>.shouldContainAllCurrencyCombinations() {
    val expectedCombinations = CryptoCurrency.values()
        .flatMap { crypto -> FiatCurrency.values().map { crypto to it } }

    currencyCombinations().shouldContainAll(expectedCombinations)
}

private fun List<CryptoCurrencyRate>.currencyCombinations() =
    map { it.cryptoCurrency to it.fiatBalance.fiatCurrency }
