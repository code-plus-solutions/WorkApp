package com.example.workapp.ui.screen.loginwithphonenumber

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.models.WorkerAndEmployee
import com.example.repository.emploer.IEmployerRepositoryImpl
import com.example.repository.worker.IWorkerRepositoryImpl
import com.example.storage.Preferences.UserPreferences
import com.example.workapp.navigation.NavActions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginWithPhoneNumberViewModel @Inject constructor(
    private val userPreferences: UserPreferences,
    private val iWorkerRepository: IWorkerRepositoryImpl,
    private val iEmployerRepository: IEmployerRepositoryImpl,
    private val context: Context,
    private val navActions: NavActions
) : ViewModel() {

    private val _phone = MutableStateFlow("")
    val phone = _phone.asStateFlow()

    private val _error = MutableStateFlow(true)
    val error = _error.asStateFlow()


    init {
        viewModelScope.launch {
            _phone.collectLatest {
                _error.value = checkPhone()
            }
        }

    }

    fun login() = viewModelScope.launch {
        if (checkPhone()) {
            if (userPreferences.workerAndEmployee == WorkerAndEmployee.Worker.name) {
                val response = iWorkerRepository.loginWork(_phone.value)
                response.collectLatest { it ->
                    it.onSuccess {
                        if (it.status == true) {
                            saveUser(
                                it.data!!.name!!,
                                it.data!!.phone!!,
                                it.data!!.address!!,
                                it.data!!.city!!,
                                it.data!!.state!!,
                                it.data!!.man!!,
                                it.data!!.avatar
                            )
                            toOtp()
                        } else {
                            Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()
                        }
                    }
                    it.onFailure {
                        if (it.message == "404") {
                            saveUser("", _phone.value, "", "", "", false, "")
                            toOtp()
                        } else {
                            Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } else if (userPreferences.workerAndEmployee == WorkerAndEmployee.Employee.name) {
                val response = iEmployerRepository.loginEmployer(_phone.value)
                response.collectLatest { it ->
                    it.onSuccess {
                        if (it.status == true) {
                            saveUser(
                                it.data!!.name!!,
                                it.data!!.phone!!,
                                it.data!!.address!!,
                                it.data!!.city!!,
                                it.data!!.state!!,
                                it.data!!.man!!,
                                it.data!!.avatar
                            )
                            toOtp()
                        } else {
                            Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()
                        }
                    }
                    it.onFailure {
                        if (it.message == "404") {
                            saveUser("", _phone.value, "", "", "", false, "")
                            toOtp()
                        } else {
                            Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        } else {
            Toast.makeText(context, "شماره تماس را به درستی وارد کنید", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveUser(
        name: String,
        phone: String,
        address: String,
        city: String,
        state: String,
        man: Boolean,
        avatar: String?
    ) = viewModelScope.launch {
        userPreferences.phone = phone
        userPreferences.name = name
        userPreferences.address = address
        userPreferences.city = city
        userPreferences.state = state
        userPreferences.man = man
        userPreferences.avatar = avatar ?: ""

    }


    fun updatePhone(phone: String) = viewModelScope.launch {
        _phone.value = phone
    }


    private fun checkPhone(): Boolean {
        if (_phone.value.isEmpty()) {
            return false
        }
        return _phone.value.count() == 11
    }

    fun backTOChooseWorkerAndEmployer() {
        navActions.navToBack()
    }

    private fun toOtp() {
        navActions.navToOtp()
    }
}