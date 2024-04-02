package com.example.datasource.emploer

import com.example.network.api.IClient
import com.example.network.model.employer.login.BodyEmployerLogin
import com.example.network.model.employer.login.EmployerLoginResponse
import com.example.network.model.employer.register.BodyEmployerRegister
import com.example.network.model.employer.register.EmployerRegisterResponse
import javax.inject.Inject

class EmployerDataSource @Inject constructor(val iClient: IClient) {
    suspend fun login(phone: String): Result<EmployerLoginResponse> {
        val response = iClient.employerLogin(BodyEmployerLogin(phone))

        if (response.isSuccessful) {
            return Result.success(response.body()!!)
        } else {
            return Result.failure(Exception(response.message()))
        }
    }


    suspend fun register(
        name: String,
        phone: String,
        address: String,
        city: String,
        state: String,
        avatar: String?,
        man: Boolean
    ): Result<EmployerRegisterResponse> {
        val response = iClient.employerRegister(
            BodyEmployerRegister(
                address = address,
                city = city,
                man = man,
                name = name,
                phone = phone,
                state = state,
            )
        )

        if (response.isSuccessful) {
            return Result.success(response.body()!!)
        } else {
            return Result.failure(Exception(response.message()))
        }
    }
}
