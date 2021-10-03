package com.greyhairredbear.racooin.apiclient

import arrow.core.Either
import arrow.core.right
import com.greyhairredbear.racooin.core.ApiClient
import com.greyhairredbear.racooin.core.ApiClientError
import com.greyhairredbear.racooin.core.model.CurrencyRate
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType

typealias CurrencyRatesResponse = List<CurrencyRate>

class CoingeckoApiClient : ApiClient {
    private val client = HttpClient {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    // TODO: deserialize {"bitcoin":{"eur":35804},"ethereum":{"eur":2456.5},"dogecoin":{"eur":0.17116}}

    override suspend fun fetchCurrencyRates(): Either<ApiClientError, List<CurrencyRate>> {
        // TODO extract etc
        val test: HttpResponse = client
            .get("https://api.coingecko.com/api/v3/simple/price") {
                parameter("ids", "ethereum,bitcoin,dogecoin")
                parameter("vs_currencies", "eur,usd")
                accept(ContentType.Application.Json)
            }
        val ignored: String = test.receive()
        return listOf<CurrencyRate>().right()
    }
}
