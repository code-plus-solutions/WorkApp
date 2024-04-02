package com.example.network.model.employer.login


import com.google.gson.annotations.SerializedName

data class BodyEmployerLogin(
    @SerializedName("phone")
    var phone: String?
)