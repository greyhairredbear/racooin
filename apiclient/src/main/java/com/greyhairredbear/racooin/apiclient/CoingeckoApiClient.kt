package com.greyhairredbear.racooin.apiclient

import arrow.core.Either
import arrow.core.right
import com.greyhairredbear.racooin.core.ApiClient
import com.greyhairredbear.racooin.core.ApiClientError
import com.greyhairredbear.racooin.core.model.CryptoCurrency
import com.greyhairredbear.racooin.core.model.CurrencyRate
import com.greyhairredbear.racooin.core.model.FiatBalance
import com.greyhairredbear.racooin.core.model.FiatCurrency
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyRatesResponse(
    val bitcoin: FiatBalanceResponse,
    val ethereum: FiatBalanceResponse,
    val dogecoin: FiatBalanceResponse,
    val litecoin: FiatBalanceResponse,
    val ripple: FiatBalanceResponse,
) {
    fun toCurrencyRates(): List<CurrencyRate> =
        mapOf(
            CryptoCurrency.BITCOIN to bitcoin,
            CryptoCurrency.ETHEREUM to ethereum,
            CryptoCurrency.DOGECOIN to dogecoin,
            CryptoCurrency.LITECOIN to litecoin,
            CryptoCurrency.RIPPLE to ripple,
        ).flatMap {
            listOf(
                CurrencyRate(it.key, FiatBalance(FiatCurrency.EURO, it.value.eur)),
                CurrencyRate(it.key, FiatBalance(FiatCurrency.US_DOLLAR, it.value.usd)),
            )
        }
}

@Serializable
data class FiatBalanceResponse(val eur: Double, val usd: Double)

// TODO extract client setup etc
class CoingeckoApiClient : ApiClient {
    private val client = HttpClient {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    override suspend fun fetchCurrencyRates(): Either<ApiClientError, List<CurrencyRate>> {
        val currencyRatesResponse: CurrencyRatesResponse = client
            .get("https://api.coingecko.com/api/v3/simple/price") {
                parameter("ids", "ethereum,bitcoin,dogecoin,litecoin,ripple")
                parameter("vs_currencies", "eur,usd")
                accept(ContentType.Application.Json)
            }

        return currencyRatesResponse.toCurrencyRates().right()
    }
}
