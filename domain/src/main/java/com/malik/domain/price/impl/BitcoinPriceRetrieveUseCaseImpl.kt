package com.malik.domain.price.impl

import com.malik.data.repository.BitcoinPriceRepositoryImpl
import com.malik.domain.price.BitcoinPriceRetrieveUseCase
import com.malik.model.BlockChainInfoResponse
import com.malik.model.PricePoint
import io.reactivex.Observable
import javax.inject.Inject


class BitcoinPriceRetrieveUseCaseImpl @Inject
constructor(private val repositoryImpl: BitcoinPriceRepositoryImpl) : BitcoinPriceRetrieveUseCase {
    companion object {
        private const val DEFAULT_PERIOD = "1years"
    }

    override fun retrieveBitcoinPrice(period: String?): Observable<BlockChainInfoResponse<PricePoint>> {
        val bitcoinPrices = period?.let {
            repositoryImpl.retrieveBitcoinPrice(it)
        } ?: repositoryImpl.retrieveBitcoinPrice(DEFAULT_PERIOD)
        return bitcoinPrices.toObservable()
    }

}