package com.example.network.model.getsms


import com.google.gson.annotations.SerializedName

data class BodyGetSms(
    @SerializedName("phone")
    var phone: String?
)