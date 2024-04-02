package com.example.network.model.checksms


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("status")
    var status: Boolean?
)