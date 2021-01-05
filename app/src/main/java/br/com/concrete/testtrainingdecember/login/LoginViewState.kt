package br.com.concrete.testtrainingdecember.login

import androidx.annotation.StringRes

sealed class LoginViewState {
    data class Error(@StringRes val errorMessageRes: Int) : LoginViewState()
    object Success : LoginViewState()
}
