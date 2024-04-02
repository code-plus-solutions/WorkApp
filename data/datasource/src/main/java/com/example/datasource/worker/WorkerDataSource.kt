package com.example.datasource.worker

import com.example.network.api.IClient
import com.example.network.model.employer.login.BodyEmployerLogin
import com.example.network.model.employer.login.EmployerLoginResponse
import com.example.network.model.employer.register.BodyEmployerRegister
import com.example.network.model.employer.register.EmployerRegisterResponse
import com.example.network.model.worker.login.BodyWorkerLogin
import com.example.network.model.worker.login.WorkerLoginResponse
import com.example.network.model.worker.register.BodyWorkerRegister
import com.example.network.model.worker.register.WorkerRegisterResponse
import javax.inject.Inject

class WorkerDataSource @Inject constructor(val iClient: IClient) {
    suspend fun login(phone: String): Result<WorkerLoginResponse> {
        val response = iClient.workerLogin(BodyWorkerLogin(phone))

        return if (response.isSuccessful) {
            Result.success(response.body()!!)
        } else {
            Result.failure(Exception(response.message()))
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
    ): Result<WorkerRegisterResponse> {
        val response = iClient.workerRegister(
            BodyWorkerRegister(
                address = address,
                city = city,
                man = man,
                name = name,
                phone = phone,
                state = state,
            )
        )

        return if (response.isSuccessful) {
            Result.success(response.body()!!)
        } else {
            Result.failure(Exception(response.message()))
        }
    }
}
