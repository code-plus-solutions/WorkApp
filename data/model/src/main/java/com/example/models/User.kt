package com.example.models

import javax.swing.SwingWorker


//class Worker(models.Model):
//    avatar = models.ImageField(upload_to="media", blank=True, null=True)
//    name = models.CharField(max_length=100)
//    phone = models.CharField(max_length=12)
//    password = models.CharField(max_length=100)
//    address = models.CharField(max_length=100)
//    city = models.CharField(max_length=100)
//    state = models.CharField(max_length=100)
//    work = models.ManyToManyField(Work, related_name="Worker")
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