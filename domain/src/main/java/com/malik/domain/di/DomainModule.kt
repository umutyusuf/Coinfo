package com.malik.domain.di

import com.malik.domain.price.BitcoinPriceRetrieveUseCase
import com.malik.domain.price.impl.BitcoinPriceRetrieveUseCaseImpl
import dagger.Binds
import dagger.Module

@Module(includes = [DataModule::class])
abstract class DomainModule {



    @Binds
    abstract fun provideRetrieveBitcoinPriceDataUseCase(priceRetrieveUseCase: BitcoinPriceRetrieveUseCaseImpl): BitcoinPriceRetrieveUseCase


}