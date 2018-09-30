package com.malik.data

import com.malik.model.BlockChainInfoResponse
import com.malik.model.PricePoint
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("charts/market-price?&format=json")
    fun retrieveBitcoinPrice(@Query("timespan") timeSpan: String):
            Single<BlockChainInfoResponse<PricePoint>>
}