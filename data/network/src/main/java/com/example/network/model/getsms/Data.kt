package com.example.network.model.getsms
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("code")
    var code: String?
)