package com.greyhairredbear.racooin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.lifecycle.lifecycleScope
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.features.get
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//curl -X 'GET' \
//'https://api.coingecko.com/api/v3/simple/price?ids=ethereum%2Cbitcoin&vs_currencies=eur' \
//-H 'accept: application/json'

//{
//    "bitcoin": {
//    "eur": 40196
//},
//    "ethereum": {
//    "eur": 2877.36
//}
//}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Hello there")
        }

        lifecycleScope.launchWhenResumed {
            withContext(Dispatchers.IO) {
                val test: HttpResponse = HttpClient {
                    install(Logging) {
                        logger = Logger.DEFAULT
                        level = LogLevel.ALL
                    }
                }
                    .get("https://api.coingecko.com/api/v3/simple/price") {
                        parameter("ids", "ethereum,bitcoin,dogecoin")
                        parameter("vs_currencies", "eur")
                        accept(ContentType.Application.Json)
                    }
                val ignored: String = test.receive()
                println(ignored)
            }
        }
    }
}
