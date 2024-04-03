package com.example.network.api

import com.example.network.model.checksms.BodyCheckSms
import com.example.network.model.getsms.BodyGetSms
import com.example.network.model.checksms.CheckSmsResponse
import com.example.network.model.employer.login.BodyEmployerLogin
import com.example.network.model.employer.login.EmployerLoginResponse
import com.example.network.model.employer.register.BodyEmployerRegister
import com.example.network.model.employer.register.EmployerRegisterResponse
import com.example.network.model.getsms.GetSmsResponse
import com.example.network.model.worker.login.BodyWorkerLogin
import com.example.network.model.worker.login.WorkerLoginResponse
import com.example.network.model.worker.register.BodyWorkerRegister
import com.example.network.model.worker.register.WorkerRegisterResponse
import com.example.network.util.Content
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface IClient {
    @POST("worker/api/login")
    suspend fun workerLogin(@Body bodyWorkerLogin: BodyWorkerLogin): Response<WorkerLoginResponse>

    @POST("worker/api/register")
    suspend fun workerRegister(@Body bodyWorkerRegister: BodyWorkerRegister): Response<WorkerRegisterResponse>

    @POST("employe/api/login")
    suspend fun employerLogin(@Body bodyEmployerLogin: BodyEmployerLogin): Response<EmployerLoginResponse>

    @POST("employe/api/register")
    suspend fun employerRegister(@Body bodyEmployerRegister:BodyEmployerRegister): Response<EmployerRegisterResponse>

    @POST("sms/api/checkSms")
    suspend fun checkSms(@Body bodyCheckSms: BodyCheckSms): Response<CheckSmsResponse>

    @POST("sms/api/getSms")
    suspend fun getSms(@Body bodyGetSms: BodyGetSms): Response<GetSmsResponse>

}
