package com.example.repository.worker

import com.example.network.model.worker.login.WorkerLoginResponse
import com.example.network.model.worker.register.WorkerRegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface IWorkerRepository {

    suspend fun loginWork(photo: String): Flow<Result<WorkerLoginResponse>>

    suspend fun registerWorker(
        name: String,
        phone: String,
        man: Boolean,
        address: String,
        city: String,
        state: String
    ): Flow<Result<WorkerRegisterResponse>>
}