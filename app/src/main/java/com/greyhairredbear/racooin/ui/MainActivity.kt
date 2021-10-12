package com.greyhairredbear.racooin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.lifecycle.lifecycleScope
import com.greyhairredbear.racooin.ui.MainScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                MainScreen()
            }
        }

        lifecycleScope.launchWhenResumed {
            withContext(Dispatchers.IO) {
                val ignored = ""
                println(ignored)
            }
        }
    }

    // TODO:
    //  onCreate:
    //  - calculate balances
    //  -- load rates
    //  --- store rates in persistence
    //      (only call api on force refresh or when older than 1h)
    //  -- load persisted balances
    //  -- multiply rates with balances
    //  -- return balance
    //  onRefresh:
    //  - calculate balances
    //  onChangeCryptoCurrency
}
