package com.example.network.model.checksms


import com.google.gson.annotations.SerializedName

data class CheckSmsResponse(
    @SerializedName("data")
    var data: Data?,
    @SerializedName("error")
    var error: String?,
    @SerializedName("status")
    var status: Boolean?
)