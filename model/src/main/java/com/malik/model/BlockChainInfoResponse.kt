package com.malik.model

import com.google.gson.annotations.SerializedName

class BlockChainInfoResponse<T>(
        @SerializedName("status")
        val status: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("unit")
        val currency: String?,
        @SerializedName("period")
        val period: String?,
        @SerializedName("description")
        val description: String?,
        @SerializedName("values")
        val values: List<T>
)