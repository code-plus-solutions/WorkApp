package com.example.network.model.worker.login


import com.google.gson.annotations.SerializedName

data class WorkerLoginData(
    @SerializedName("phone")
    var phone: String?
)