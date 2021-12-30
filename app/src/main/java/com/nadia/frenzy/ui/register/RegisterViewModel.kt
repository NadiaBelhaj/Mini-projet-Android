package com.nadia.frenzy.ui.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nadia.frenzy.data.RegisterData
import com.nadia.frenzy.data.SessionData
import com.nadia.frenzy.data.source.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val registerLiveData : MutableLiveData<SessionData> = MutableLiveData()

    fun userRegister(registerData: RegisterData){
        viewModelScope.launch {
            val result = authRepository.register(registerData)
            if (result.isSuccess) {
                val response = result.getOrNull()
                Log.d("nadia", "Response code ${response?.code()} ${response?.message()}")
                when(response?.code()) {
                    200 -> {
                        val sessionData = response.body()
                        registerLiveData.postValue(sessionData)
                    }
                    else -> registerLiveData.postValue(null)
                }
            }
            else {
                registerLiveData.postValue(null)
            }
        }
    }

    fun getRegisterLiveData() = registerLiveData
}