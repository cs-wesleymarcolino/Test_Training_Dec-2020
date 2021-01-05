package br.com.concrete.testtrainingdecember

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.concrete.testtrainingdecember.login.LoginViewModel
import br.com.concrete.testtrainingdecember.login.LoginViewState
import br.com.concrete.testtrainingdecember.utils.PasswordValidator
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val mockedPasswordValidator = mockk<PasswordValidator>()
    private val loginViewModel = LoginViewModel(mockedPasswordValidator)

    @Test
    fun givenEmptyPassword_whenValidatingLogin_shouldEmitEmptyPasswordError() {
        loginViewModel.validateLogin(
            "email",
            ""
        )

        assertEquals(
            loginViewModel.getViewState().value,
            LoginViewState.Error(R.string.error_password_is_empty)
        )
    }

    @Test
    fun givenEmptyEmail_whenValidatingLogin_shouldEmitEmptyEmailError() {
        loginViewModel.validateLogin(
            "",
            "password"
        )

        assertEquals(
            loginViewModel.getViewState().value,
            LoginViewState.Error(R.string.error_email_is_empty)
        )
    }

    @Test
    fun givenInvalidPassword_whenValidatingLogin_shouldEmitInvalidPasswordError() {
        every {
            mockedPasswordValidator.isValid(any())
        } returns false

        loginViewModel.validateLogin(
            "email",
            "password"
        )

        assertEquals(
            loginViewModel.getViewState().value,
            LoginViewState.Error(R.string.error_password_is_invalid)
        )
    }

    @Test
    fun givenValidPassword_whenValidatingLogin_shouldEmitSuccess() {
        every {
            mockedPasswordValidator.isValid(any())
        } returns true

        loginViewModel.validateLogin(
            "email",
            "password"
        )

        assertEquals(
            loginViewModel.getViewState().value,
            LoginViewState.Success
        )
    }
}