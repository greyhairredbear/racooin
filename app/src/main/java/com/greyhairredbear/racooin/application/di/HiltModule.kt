package com.greyhairredbear.racooin.application.di

import android.content.Context
import com.greyhairredbear.racooin.apiclient.CoingeckoApiClient
import com.greyhairredbear.racooin.core.interfaces.ApiClient
import com.greyhairredbear.racooin.core.interfaces.Persistence
import com.greyhairredbear.racooin.persistence.DataStorePersistence
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {
    @Provides
    fun provideApiClient(): ApiClient = CoingeckoApiClient()

    @Provides
    fun providePersistence(@ApplicationContext applicationContext: Context): Persistence =
        DataStorePersistence(applicationContext)
}
