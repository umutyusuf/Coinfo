package com.malik.data.datasource

import com.malik.model.BlockChainInfoResponse
import com.malik.model.PricePoint
import io.reactivex.Single

interface BitcoinPriceDataSource {
    fun retrievePriceData(period: String): Single<BlockChainInfoResponse<PricePoint>>
}