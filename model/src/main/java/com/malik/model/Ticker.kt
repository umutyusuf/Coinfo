package com.malik.model

import com.google.gson.annotations.SerializedName

class Ticker(
        @SerializedName("15m")
        val delayedPrice: Float?,
        @SerializedName("last")
        val currentMarketPrice: Float?,
        @SerializedName("buy")
        val purchasePrice: Float?,
        @SerializedName("sellPrice")
        val sellPrice: Float?,
        @SerializedName("symbol")
        val currencySymbol: String?
)