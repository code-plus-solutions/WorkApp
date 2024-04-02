package com.example.network.model.employer.register


import com.google.gson.annotations.SerializedName

data class EmployerRegisterResponse(
    @SerializedName("data")
    var `data`: Data?,
    @SerializedName("error")
    var error: String?,
    @SerializedName("status")
    var status: Boolean?
)