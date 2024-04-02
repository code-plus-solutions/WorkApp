package com.example.network.model.getsms
import com.google.gson.annotations.SerializedName

data class GetSmsResponse(
    @SerializedName("data")
    var data: Data?,
    @SerializedName("error")
    var error: Any?,
    @SerializedName("status")
    var status: Boolean?
)