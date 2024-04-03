package com.example.workapp.ui.screen.chooseworkerandemployer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.models.WorkerAndEmployee
import com.example.storage.Preferences.UserPreferences
import com.example.workapp.navigation.NavActions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenChooseWorkerAndEmployerViewmodel @Inject constructor(
    val navActions: NavActions,
    val UserPreferences: UserPreferences
) : ViewModel() {

    init {
        if (UserPreferences.phone != "0")
            navActions.navToHome()
    }


    fun onClickChooseWorker() = viewModelScope.launch {
        UserPreferences.workerAndEmployee = WorkerAndEmployee.Worker.name
        navActions.navToLoginWithPhoneNumber()
    }


    fun onClickChooseEmployer() = viewModelScope.launch {
        UserPreferences.workerAndEmployee = WorkerAndEmployee.Employee.name
        navActions.navToLoginWithPhoneNumber()
    }
}