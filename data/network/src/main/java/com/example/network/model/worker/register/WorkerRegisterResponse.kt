package com.example.network.model.worker.register


import com.google.gson.annotations.SerializedName

data class WorkerRegisterResponse(
    @SerializedName("data")
    var data: Data?,
    @SerializedName("error")
    var error: Any?,
    @SerializedName("status")
    var status: Boolean?
)