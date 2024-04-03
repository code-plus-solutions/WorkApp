package com.example.storage.Preferences

import android.annotation.SuppressLint
import android.content.SharedPreferences
import javax.inject.Inject

class UserPreferences @Inject constructor(val preferences: SharedPreferences) : IUserPreferences {
    override var name: String
        get() = preferences.getString("name", "") ?: ""
        set(value) = preferences.edit().putString("name", value).apply()

    override var phone: String
        get() = preferences.getString("phone", "0") ?: "0"
        set(value) = preferences.edit().putString("phone", value).apply()


    override var address: String
        get() = preferences.getString("address", "") ?: ""
        set(value) = preferences.edit().putString("address", value).apply()


    override var city: String
        get() = preferences.getString("city", "") ?: ""
        set(value) = preferences.edit().putString("city", value).apply()


    override var state: String
        get() = preferences.getString("state", "") ?: ""
        set(value) = preferences.edit().putString("state", value).apply()


    override var avatar: String
        get() = preferences.getString("avatar", "") ?: ""
        set(value) = preferences.edit().putString("avatar", value).apply()


    override var work: String
        get() = preferences.getString("work", "") ?: ""
        set(value) = preferences.edit().putString("work", value).apply()


    override var password: String
        get() = preferences.getString("password", "") ?: ""
        set(value) = preferences.edit().putString("password", value).apply()


    override var workerAndEmployee: String
        get() = preferences.getString("workerAndEmployee", "") ?: ""
        set(value) = preferences.edit().putString("workerAndEmployee", value).apply()
    override var man: Boolean
        get() = preferences.getBoolean("man", true)
        set(value) = preferences.edit().putBoolean("man", value).apply()

}