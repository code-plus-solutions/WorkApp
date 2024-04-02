package com.example.repository.worker

import com.example.datasource.worker.WorkerDataSource
import com.example.network.model.worker.login.WorkerLoginResponse
import com.example.network.model.worker.register.WorkerRegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class IWorkerRepositoryImpl @Inject constructor(val workerDataSource: WorkerDataSource) :
    IWorkerRepository {

    override suspend fun loginWork(photo: String): Flow<Result<WorkerLoginResponse>> =
        flow<Result<WorkerLoginResponse>> {
            val response = workerDataSource.login(photo)

            response.onSuccess {
                emit(Result.success(it))
            }

            response.onFailure {
                emit(Result.failure(it))
            }

        }.flowOn(Dispatchers.IO)

    override suspend fun registerWorker(
        name: String,
        phone: String,
        man: Boolean,
        address: String,
        city: String,
        state: String
    ): Flow<Result<WorkerRegisterResponse>> =
        flow<Result<WorkerRegisterResponse>> {
            val response = workerDataSource.register(
                name = name,
                phone = phone,
                man = man,
                address = address,
                city = city,
                state = state,
                avatar = null
            )

            response.onSuccess {
                if (it.status!!) {
                    emit(Result.success(it))
                } else {
                    emit(Result.failure(Exception(it.error)))
                }
            }

            response.onFailure {
                emit(Result.failure(it))
            }

        }.flowOn(Dispatchers.IO)
}