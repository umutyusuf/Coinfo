package com.malik.domain.di

import com.malik.data.NetworkServiceProvider
import com.malik.data.datasource.BitcoinPriceDataSource
import com.malik.data.datasource.remote.BitcoinPriceRemoteDataSource
import com.malik.data.repository.BitcoinPriceRepository
import com.malik.data.repository.BitcoinPriceRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule(private val baseUrl: String, private val allowLogging: Boolean) {
    @Singleton
    @Provides
    fun provideNetworkServiceProvider(): NetworkServiceProvider {
        return NetworkServiceProvider(baseUrl, allowLogging)
    }

    @Singleton
    @Provides
    fun provideBitcoinPriceRemoteDataSource(networkServiceProvider: NetworkServiceProvider): BitcoinPriceDataSource {
        return BitcoinPriceRemoteDataSource(networkServiceProvider.getNetworkService())
    }

    @Singleton
    @Provides
    fun provideBitcoinPriceRepository(bitcoinPriceDataSource: BitcoinPriceDataSource): BitcoinPriceRepository {
        return BitcoinPriceRepositoryImpl(bitcoinPriceDataSource)
    }
}