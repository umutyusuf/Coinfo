package com.malik.domain.price

import com.malik.model.BlockChainInfoResponse
import com.malik.model.PricePoint
import io.reactivex.Observable

interface BitcoinPriceRetrieveUseCase {
    fun retrieveBitcoinPrice(period: String?) : Observable<BlockChainInfoResponse<PricePoint>>
}