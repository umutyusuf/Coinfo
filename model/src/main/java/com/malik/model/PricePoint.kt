package com.malik.model

import com.google.gson.annotations.SerializedName

class PricePoint(
        @SerializedName("x")
        val timestamp: Long?,
        @SerializedName("y")
        val price: Float?
)