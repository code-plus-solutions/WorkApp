package com.example.network.model.checksms


import com.google.gson.annotations.SerializedName

data class BodyCheckSms(
    @SerializedName("code")
    var code: String?,
    @SerializedName("phone")
    var phone: String?
)