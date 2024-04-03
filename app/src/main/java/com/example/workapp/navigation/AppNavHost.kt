package com.example.workapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.workapp.ui.screen.chooseworkerandemployer.ScreenChooseWorkerAndEmployer
import com.example.workapp.ui.screen.ScreenEmployerRegister
import com.example.workapp.ui.screen.ScreenHome
import com.example.workapp.ui.screen.loginwithphonenumber.ScreenLoginWithPhoneNumber
import com.example.workapp.ui.screen.otp.ScreenOtp
import com.example.workapp.ui.screen.ScreenWorkerRegister


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Screens.ScreenChooseWorkerAndEmployer.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screens.ScreenChooseWorkerAndEmployer.route) {
            ScreenChooseWorkerAndEmployer()
        }
        composable(Screens.ScreenLoginWithPhoneNumber.route){
            ScreenLoginWithPhoneNumber()
        }
        composable(Screens.ScreenOtp.route){
            ScreenOtp()
        }
        composable(Screens.ScreenWorkerRegister.route){
            ScreenWorkerRegister()
        }
        composable(Screens.ScreenEmployerRegister.route){
            ScreenEmployerRegister()
        }
        composable(Screens.ScreenHome.route){
            ScreenHome()
        }

    }
}
