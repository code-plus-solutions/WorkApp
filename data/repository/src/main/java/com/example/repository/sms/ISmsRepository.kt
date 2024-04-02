package com.example.repository.sms

import com.example.network.model.checksms.CheckSmsResponse
import com.example.network.model.getsms.GetSmsResponse
import kotlinx.coroutines.flow.Flow

interface ISmsRepository {
    suspend fun getSms(phone: String): Flow<Result<GetSmsResponse>>

    suspend fun checkSms(phone: String, code: String): Flow<Result<CheckSmsResponse>>
}