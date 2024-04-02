package com.example.network.model.employer.register


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("address")
    var address: String?,
    @SerializedName("avatar")
    var avatar: Any?,
    @SerializedName("city")
    var city: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("man")
    var man: Boolean?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("phone")
    var phone: String?,
    @SerializedName("state")
    var state: String?
)