package com.example.workapp.data.utils

import Api_interface
import com.example.workapp.data.domain.base_url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofit_client {

    val api : Api_interface by lazy {
        Retrofit.Builder()
            .baseUrl(base_url.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api_interface::class.java)
    }


}