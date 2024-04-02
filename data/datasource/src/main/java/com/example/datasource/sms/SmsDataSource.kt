package com.example.datasource.sms

import android.provider.ContactsContract.CommonDataKinds.Phone
import com.example.network.api.IClient
import com.example.network.model.checksms.BodyCheckSms
import com.example.network.model.checksms.CheckSmsResponse
import com.example.network.model.getsms.BodyGetSms
import com.example.network.model.getsms.GetSmsResponse
import javax.inject.Inject

class SmsDataSource @Inject constructor(val iClient: IClient) {
    suspend fun getSms(phone: String):Result<GetSmsResponse> {
        val response = iClient.getSms(BodyGetSms(phone))

        return if (response.isSuccessful){
            Result.success(response.body()!!)
        }else{
            Result.failure(Exception(response.message()))
        }
    }

    suspend fun checkSms(phone: String,code:String):Result<CheckSmsResponse> {
        val response = iClient.checkSms(BodyCheckSms(phone,code))

        return if (response.isSuccessful){
            Result.success(response.body()!!)
        }else{
            Result.failure(Exception(response.message()))
        }
    }
}