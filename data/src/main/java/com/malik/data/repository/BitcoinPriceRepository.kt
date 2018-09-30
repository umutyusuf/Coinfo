package com.malik.data.repository

import com.malik.model.BlockChainInfoResponse
import com.malik.model.PricePoint
import io.reactivex.Single

interface BitcoinPriceRepository {
    fun retrieveBitcoinPrice(period: String): Single<BlockChainInfoResponse<PricePoint>>
}