package com.example.network.model.employer.login


import com.google.gson.annotations.SerializedName

data class EmployerLoginResponse(
    @SerializedName("data")
    var data: Data?,
    @SerializedName("error")
    var error: Any?,
    @SerializedName("status")
    var status: Boolean?
)