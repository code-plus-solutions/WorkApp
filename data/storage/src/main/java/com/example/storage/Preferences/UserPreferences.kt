package com.example.storage.Preferences

import android.annotation.SuppressLint
import android.content.SharedPreferences
import javax.inject.Inject

class UserPreferences @Inject constructor(val preferences: SharedPreferences): IUserPreferences {
    override var name: String
        get() = preferences.getString("name","")?:""
        @SuppressLint("CommitPrefEdits")
        set(value) {preferences.edit().putString("name",value)}
    override var phone: String
        get() = preferences.getString("phone","")?:""
        @SuppressLint("CommitPrefEdits")
        set(value) {preferences.edit().putString("phone",value)}

    override var address: String
        get() = preferences.getString("address","")?:""
        @SuppressLint("CommitPrefEdits")
        set(value) {preferences.edit().putString("address",value)}

    override var city: String
        get() = preferences.getString("city","")?:""
        @SuppressLint("CommitPrefEdits")
        set(value) {preferences.edit().putString("city",value)}

    override var state: String
        get() = preferences.getString("state","")?:""
        @SuppressLint("CommitPrefEdits")
        set(value) {preferences.edit().putString("state",value)}

    override var avatar: String
        get() = preferences.getString("avatar","")?:""
        @SuppressLint("CommitPrefEdits")
        set(value) {preferences.edit().putString("avatar",value)}

    override var work: String
        get() = preferences.getString("work","")?:""
        @SuppressLint("CommitPrefEdits")
        set(value) {preferences.edit().putString("work",value)}

    override var password: String
        get() = preferences.getString("password","")?:""
        @SuppressLint("CommitPrefEdits")
        set(value) {preferences.edit().putString("password",value)}

    override var workerAndEmployee: String
        get() = preferences.getString("workerAndEmployee","")?:""
        @SuppressLint("CommitPrefEdits")
        set(value) {preferences.edit().putString("workerAndEmployee",value)}
    override var man: Boolean
        get() = preferences.getBoolean("man",true)
        @SuppressLint("CommitPrefEdits")
        set(value) {preferences.edit().putBoolean("man",value)}

}