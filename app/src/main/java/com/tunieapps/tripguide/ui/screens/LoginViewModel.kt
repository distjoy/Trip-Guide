package com.tunieapps.tripguide.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var i = listOf("https://images.dog.ceo/breeds/mix/Milka5.jpg",
        "https://images.dog.ceo/breeds/bluetick/n02088632_2060.jpg",
        "https://images.dog.ceo/breeds/shihtzu/n02086240_1366.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_2325.jpg",
        "https://images.dog.ceo/breeds/terrier-norwich/n02094258_1004.jpg")

    private val _showError = MutableStateFlow<Error?>(null)

    val showError = _showError.asStateFlow()
    private val _imgUrl = MutableStateFlow<String>("")

    val imgUrl = _imgUrl.asStateFlow()


    fun updateError() {
        Log.d("LoginViewModel","updateError")
        _showError.value = Error.CoreError
    }

    fun resetError() {
        Log.d("LoginViewModel","resetError")
        _showError.value = null
    }

    fun getImage()=
        flow<String> {
            delay(2000)
            emit(i[Random.nextInt(0,5)])
        }

    fun getImage(uri : String)=
       viewModelScope.launch {
           _imgUrl.value = uri
       }

    sealed class  Error {
        data object CoreError : Error()
        data object TypeError : Error()
    }
}