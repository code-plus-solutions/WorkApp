package com.example.repository.emploer

import com.example.datasource.emploer.EmployerDataSource
import com.example.datasource.worker.WorkerDataSource
import com.example.network.model.employer.login.EmployerLoginResponse
import com.example.network.model.employer.register.EmployerRegisterResponse
import com.example.network.model.worker.login.WorkerLoginResponse
import com.example.network.model.worker.register.WorkerRegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class IEmployerRepositoryImpl @Inject constructor(val employerDataSource: EmployerDataSource) :
    IEmployerRepository {

    override suspend fun loginWork(photo: String): Flow<Result<EmployerLoginResponse>> =
        flow<Result<EmployerLoginResponse>> {
            val response = employerDataSource.login(photo)

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
    ): Flow<Result<EmployerRegisterResponse>> =
        flow<Result<EmployerRegisterResponse>> {
            val response = employerDataSource.register(
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