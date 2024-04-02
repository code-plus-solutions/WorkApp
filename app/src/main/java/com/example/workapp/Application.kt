package com.example.workapp

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application : Application() {
    override fun getApplicationContext(): Context {
        return super.getApplicationContext()
    }
}