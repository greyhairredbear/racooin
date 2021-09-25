package com.greyhairredbear.racooin.apiclient

import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

val sut = CoingeckoApiClient()

class ApiClientTest: FunSpec({
    test("should fetch currencies from api") {
        val result = sut.fetchCurrencyRates()
        result
            .shouldBeRight()
            .shouldBe(emptyList())
    }
})
