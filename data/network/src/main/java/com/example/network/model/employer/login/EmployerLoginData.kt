package com.example.network.model.employer.login


import com.google.gson.annotations.SerializedName

data class EmployerLoginData(
    @SerializedName("phone")
    var phone: String?
)