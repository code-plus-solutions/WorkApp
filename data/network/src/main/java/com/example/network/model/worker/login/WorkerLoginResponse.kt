package com.example.network.model.worker.login


import com.google.gson.annotations.SerializedName

data class WorkerLoginResponse(
    @SerializedName("data")
    var data: Data?,
    @SerializedName("error")
    var error: Any?,
    @SerializedName("status")
    var status: Boolean?
)