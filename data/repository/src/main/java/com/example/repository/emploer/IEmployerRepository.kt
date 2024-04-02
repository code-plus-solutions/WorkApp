package com.example.repository.emploer

import com.example.network.model.employer.login.EmployerLoginResponse
import com.example.network.model.employer.register.EmployerRegisterResponse
import com.example.network.model.worker.login.WorkerLoginResponse
import com.example.network.model.worker.register.WorkerRegisterResponse
import kotlinx.coroutines.flow.Flow

interface IEmployerRepository {

    suspend fun loginWork(photo: String): Flow<Result<EmployerLoginResponse>>

    suspend fun registerWorker(
        name: String,
        phone: String,
        man: Boolean,
        address: String,
        city: String,
        state: String
    ): Flow<Result<EmployerRegisterResponse>>
}