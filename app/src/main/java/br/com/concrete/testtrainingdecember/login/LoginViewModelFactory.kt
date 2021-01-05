package br.com.concrete.testtrainingdecember.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.concrete.testtrainingdecember.utils.PasswordValidator

class LoginViewModelFactory(
    private val passwordValidator: PasswordValidator
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(passwordValidator) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}