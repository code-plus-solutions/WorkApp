package com.example.network.api

import com.example.network.model.checksms.BodyCheckSms
import com.example.network.model.getsms.BodyGetSms
import com.example.network.model.checksms.CheckSmsResponse
import com.example.network.model.getsms.GetSmsResponse
import retrofit2.Response
import retrofit2.http.POST

interface IClient {
    @POST()
    suspend fun workerLogin(): String

    @POST()
    suspend fun workerRegister(): String

    @POST()
    suspend fun employerLogin(): String

    @POST("employe/api/register")
    suspend fun employerRegister(): String

    @POST("sms/api/checkSms")
    suspend fun checkSms(bodyCheckSms: BodyCheckSms): Response<CheckSmsResponse>

    @POST("sms/api/getSms")
    suspend fun getSms(bodyGetSms: BodyGetSms): Response<GetSmsResponse>

}