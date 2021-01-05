package br.com.concrete.testtrainingdecember.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.concrete.testtrainingdecember.utils.PasswordValidator
import br.com.concrete.testtrainingdecember.R

class LoginViewModel(
    private val passwordValidator: PasswordValidator
) : ViewModel() {

    private val state = MutableLiveData<LoginViewState>()

    fun getViewState(): LiveData<LoginViewState> = state

    fun validateLogin(email: String, password: String) {
        state.value = when {
            email.isEmpty() -> LoginViewState.Error(R.string.error_email_is_empty)
            password.isEmpty() -> LoginViewState.Error(R.string.error_password_is_empty)
            !passwordValidator.isValid(password) -> LoginViewState.Error(R.string.error_password_is_invalid)
            else -> LoginViewState.Success
        }
    }
}
