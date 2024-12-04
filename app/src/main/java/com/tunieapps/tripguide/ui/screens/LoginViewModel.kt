package com.tunieapps.tripguide.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {


    private val _showError = MutableStateFlow<Error?>(null)

    val showError = _showError.asStateFlow()

    fun updateError() {
        Log.d("LoginViewModel","updateError")
        _showError.value = Error.CoreError
    }

    fun resetError() {
        Log.d("LoginViewModel","resetError")
        _showError.value = null
    }

    sealed class  Error {
        data object CoreError : Error()
        data object TypeError : Error()
    }
}