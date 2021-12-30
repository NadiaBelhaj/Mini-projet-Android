package com.nadia.frenzy.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nadia.frenzy.data.LoginData
import com.nadia.frenzy.data.SessionData
import com.nadia.frenzy.data.source.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel(){

    private val sessionLiveData : MutableLiveData<SessionData> = MutableLiveData()

    fun userLogin(loginData: LoginData){
        viewModelScope.launch {
            val result = authRepository.login(loginData)
            val response = result.getOrNull()
            if (response?.code() == 200) {
                val sessionData = response.body()
                sessionLiveData.postValue(sessionData)
            }
            else {
                sessionLiveData.postValue(null)
            }
        }
    }

    fun getSessionLiveData() = sessionLiveData
}