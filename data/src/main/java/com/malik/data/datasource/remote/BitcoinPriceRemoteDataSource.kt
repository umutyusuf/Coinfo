package com.malik.data.datasource.remote

import com.malik.data.NetworkService
import com.malik.data.datasource.BitcoinPriceDataSource
import com.malik.model.BlockChainInfoResponse
import com.malik.model.PricePoint
import io.reactivex.Single
import javax.inject.Inject

class BitcoinPriceRemoteDataSource @Inject
constructor(private val networkService: NetworkService) : BitcoinPriceDataSource {

    override fun retrievePriceData(period: String): Single<BlockChainInfoResponse<PricePoint>> {
        return networkService.retrieveBitcoinPrice(period)
    }

}