package com.example.repository.sms

import com.example.datasource.sms.SmsDataSource
import com.example.network.model.checksms.CheckSmsResponse
import com.example.network.model.getsms.GetSmsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class ISmsRepositoryImpl @Inject constructor(val dataSource: SmsDataSource) : ISmsRepository {
    override suspend fun getSms(phone: String): Flow<Result<GetSmsResponse>> =
        flow<Result<GetSmsResponse>> {
            val response = dataSource.getSms(phone)

            response.onFailure {
                emit(Result.failure(it))
            }
            response.onSuccess {
                emit(Result.success(it))
            }
        }.flowOn(Dispatchers.IO)

    override suspend fun checkSms(phone: String, code: String): Flow<Result<CheckSmsResponse>> =
        flow<Result<CheckSmsResponse>> {
            val response = dataSource.checkSms(phone =phone,code = code)

            response.onFailure {
                emit(Result.failure(it))
            }
            response.onSuccess {
                emit(Result.success(it))
            }
        }.flowOn(Dispatchers.IO)
}