package com.example.network.model.worker.register


import com.google.gson.annotations.SerializedName

data class BodyWorkerRegister(
    @SerializedName("address")
    var address: String?,
    @SerializedName("city")
    var city: String?,
    @SerializedName("man")
    var man: Boolean?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("phone")
    var phone: String?,
    @SerializedName("state")
    var state: String?
)