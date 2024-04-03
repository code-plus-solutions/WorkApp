package com.example.workapp.ui.screen.otp

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.models.WorkerAndEmployee
import com.example.repository.sms.ISmsRepositoryImpl
import com.example.storage.Preferences.UserPreferences
import com.example.workapp.navigation.NavActions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtpViewModel @Inject constructor(
    val navActions: NavActions,
    val userPreferences: UserPreferences,
    val iSmsRepository: ISmsRepositoryImpl,
    val context: Context
) : ViewModel() {

    private var _phone = MutableStateFlow<String>(userPreferences.phone)
    val phone = _phone.asStateFlow()

    private var _code = MutableStateFlow<String>("")
    val code = _code.asStateFlow()

    private var _time = MutableStateFlow<String>("00:60")
    val time = _time.asStateFlow()


    init {
        getSms()
    }

    fun getSms() = viewModelScope.launch {
        val response = iSmsRepository.getSms(_phone.value)
        response.collectLatest {
            it.onSuccess {
                if (it.status == true) {
                    Toast.makeText(context, "کد با موفقیت ارسال شد", Toast.LENGTH_SHORT).show()
                    startTimer()
                } else {
                    Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()
                }
            }
            it.onFailure {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun checkCode() = viewModelScope.launch {
        if (_code.value.length == 4) {
            Log.d("aaa", "checkCode: " + _code.value + "_" + _phone.value)
            val response = iSmsRepository.checkSms(phone = _phone.value, code = _code.value)
            response.collectLatest {
                it.onSuccess {
                    if (it.status == true) {
                        if (userPreferences.name == "") {
                            navToRegister()
                        } else {
                            Toast.makeText(context, "کد صحیح است", Toast.LENGTH_SHORT).show()
                            navActions.navToHome()
                        }
                    } else {
                        Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()
                    }
                }
                it.onFailure {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(context, "کد کامل را وارد کنید", Toast.LENGTH_SHORT).show()
        }
    }

    fun navToRegister() {
        when (userPreferences.workerAndEmployee) {
            WorkerAndEmployee.Employee.name -> navActions.navToEmployerRegister()
            WorkerAndEmployee.Worker.name -> navActions.navToWorkerRegister()
        }
    }

    fun setCode(code: String) {
        _code.value = code
    }

    fun changesPhone() {
        userPreferences.phone = ""
        navActions.navToBack()
    }

    private fun startTimer() = viewModelScope.launch(Dispatchers.IO) {
        for (i in 60 downTo 0) {
            _time.value = "00:${if (i > 9) i else "0$i"}"
            delay(2000)
        }
    }
}