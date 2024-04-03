package com.example.models

import javax.swing.SwingWorker

data class User(
    var avatar: String?,
    var name: String,
    var phone: String,
    var password: String,
    var address: String,
    var city: String,
    var state: String,
    var work:Work?,
    var workerAndEmployee :String
)