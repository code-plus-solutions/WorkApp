package com.example.workapp.navigation

sealed class Screens (val route:String){
    data object ScreenChooseWorkerAndEmployer : Screens("ChooseWorkerAndEmployer")
    data object ScreenLoginWithPhoneNumber : Screens("LoginWithPhoneNumber")
    data object ScreenOtp : Screens("ScreensOtp")
    data object ScreenEmployerRegister : Screens("EmployerRegister")
    data object ScreenWorkerRegister : Screens("WorkerRegister")
}