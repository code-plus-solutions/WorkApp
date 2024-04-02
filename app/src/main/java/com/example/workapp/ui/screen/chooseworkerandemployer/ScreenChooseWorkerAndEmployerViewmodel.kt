package com.example.workapp.ui.screen.chooseworkerandemployer

import androidx.lifecycle.ViewModel
import com.example.models.WorkerAndEmployee
import com.example.storage.Preferences.UserPreferences
import com.example.workapp.navigation.NavActions
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenChooseWorkerAndEmployerViewmodel @Inject constructor(
    val navActions: NavActions,
    val UserPreferences: UserPreferences
) : ViewModel() {

    fun onClickChooseWorker() {
        UserPreferences.workerAndEmployee = WorkerAndEmployee.Worker.name
        navActions.navToLoginWithPhoneNumber()
    }

    fun onClickChooseEmployer() {
        UserPreferences.workerAndEmployee = WorkerAndEmployee.Worker.name
        navActions.navToLoginWithPhoneNumber()
    }
}