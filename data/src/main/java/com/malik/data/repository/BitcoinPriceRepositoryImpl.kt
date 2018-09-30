package com.malik.data.repository

import com.malik.data.datasource.BitcoinPriceDataSource
import com.malik.model.BlockChainInfoResponse
import com.malik.model.PricePoint
import io.reactivex.Single
import javax.inject.Inject

class BitcoinPriceRepositoryImpl @Inject
constructor(private val remoteDataSource: BitcoinPriceDataSource) : BitcoinPriceRepository {

    override fun retrieveBitcoinPrice(period: String): Single<BlockChainInfoResponse<PricePoint>> {
        return remoteDataSource.retrievePriceData(period)
    }

}