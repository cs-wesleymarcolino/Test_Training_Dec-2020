package br.com.concrete.testtrainingdecember

import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.concrete.testtrainingdecember.login.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    val activityTestRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun givenInitialState_shouldHaveEmptyEmailAndPassword() {
        loginAssert {
            checkEmailFieldIsEmpty()
            checkPasswordFieldIsEmpty()
        }
    }

    @Test
    fun givenEmailIsEmpty_whenLogin_shouldShowEmptyEmailError() {
        loginAct {
            typePassword("aA.123232jkh")
            clickLogin()
        }
        loginAssert {
            checkMessageWasShown(R.string.error_email_is_empty)
        }
    }

    @Test
    fun givenPasswordIsEmpty_whenLogin_shouldShowEmptyPasswordError() {
        loginAct {
            typeEmail("wesley.marcolino@concrete.com.br")
            clickLogin()
        }

        loginAssert {
            checkMessageWasShown(R.string.error_password_is_empty)
        }
    }

    @Test
    fun givenInvalidPassword_whenLogin_shouldShowInvalidPasswordError() {
        loginAct {
            typeEmail("wesley.marcolino@concrete.com.br")
            typePassword("a1234")
            clickLogin()
        }

        loginAssert {
            checkMessageWasShown(R.string.error_password_is_invalid)
        }
    }

    @Test
    fun givenValidEmailAndPassword_whenLogin_shouldGoToHomescreen() {
        Intents.init()

        loginArrange {
            mockHomeActivityIntent()
        }

        loginAct {
            typeEmail("wesley.marcolino@concrete.com.br")
            typePassword("aA15$.1234")
            clickLogin()
        }

        loginAssert {
            checkHomescreenActivityWasCalled()
        }

        Intents.release()
    }
}