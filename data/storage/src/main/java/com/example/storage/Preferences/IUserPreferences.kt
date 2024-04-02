package com.example.storage.Preferences

import androidx.annotation.WorkerThread

interface IUserPreferences {

    @get:WorkerThread
    @set:WorkerThread
    var name: String

    @get:WorkerThread
    @set:WorkerThread
    var phone: String

    @get:WorkerThread
    @set:WorkerThread
    var address: String

    @get:WorkerThread
    @set:WorkerThread
    var city: String

    @get:WorkerThread
    @set:WorkerThread
    var state: String

    @get:WorkerThread
    @set:WorkerThread
    var avatar: String

    @get:WorkerThread
    @set:WorkerThread
    var work: String

    @get:WorkerThread
    @set:WorkerThread
    var password: String

    @get:WorkerThread
    @set:WorkerThread
    var workerAndEmployee: String

    @get:WorkerThread
    @set:WorkerThread
    var man: Boolean


}