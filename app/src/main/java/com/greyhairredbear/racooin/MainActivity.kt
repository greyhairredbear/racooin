package com.greyhairredbear.racooin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.lifecycle.lifecycleScope
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
                val ignored = ""
                println(ignored)
            }
        }
    }
}
