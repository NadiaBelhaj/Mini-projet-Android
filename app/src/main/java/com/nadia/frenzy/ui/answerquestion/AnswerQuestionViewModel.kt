package com.nadia.frenzy.ui.answerquestion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nadia.frenzy.data.AnswerData
import com.nadia.frenzy.data.Question
import com.nadia.frenzy.data.ResponseType
import com.nadia.frenzy.data.source.AnswerRepository
import com.nadia.frenzy.data.source.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnswerQuestionViewModel @Inject constructor(
    private val questionRepository : QuestionRepository,
    private val answerRepository: AnswerRepository
) : ViewModel() {

    private val questionLiveData : MutableLiveData<Question> = MutableLiveData()
    private val answerLiveData : MutableLiveData<ResponseType> = MutableLiveData()

    fun getQuestionById(token : String, id : String){
        viewModelScope.launch {
            val result = questionRepository.getQuestionById(token, id)
            if (result.isSuccess) {
                questionLiveData.postValue(result.getOrNull())
            }
        }
    }

    fun answerQuestion(token : String, answerData: AnswerData){
        viewModelScope.launch {
            val result = answerRepository.answerOneQuestion(token, answerData)
            if (result.isSuccess) {
                val response = result.getOrNull()
                when(response?.code()){
                    200 -> answerLiveData.postValue(ResponseType.SUCCESS)
                    401 -> answerLiveData.postValue(ResponseType.NO_AUTH)
                    else -> answerLiveData.postValue(ResponseType.FAILURE)
                }
            } else {
                answerLiveData.postValue(ResponseType.FAILURE)
            }
        }
    }

    fun getQuestionLiveData() = questionLiveData
    fun getAnswerLiveData() = answerLiveData
}