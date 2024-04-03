package com.example.workapp.navigation

import androidx.navigation.NavController

class NavActions() {
    var navController: NavController? = null

    fun navToChooseWorkerAndEmployer(){
        navController?.navigate(Screens.ScreenChooseWorkerAndEmployer.route)
    }
    fun navToLoginWithPhoneNumber(){
        navController?.navigate(Screens.ScreenLoginWithPhoneNumber.route)
    }
    fun navToOtp(){
        navController?.navigate(Screens.ScreenOtp.route)
    }
    fun navToWorkerRegister(){
        navController?.navigate(Screens.ScreenWorkerRegister.route)
    }
    fun navToEmployerRegister(){
        navController?.navigate(Screens.ScreenEmployerRegister.route)
    }

    fun navTo(route:String){
        navController?.navigate(route)
    }

    fun navToHome(){
        navController?.navigate(Screens.ScreenHome.route)
    }

    fun navToBack(){
        navController?.popBackStack()
    }
}