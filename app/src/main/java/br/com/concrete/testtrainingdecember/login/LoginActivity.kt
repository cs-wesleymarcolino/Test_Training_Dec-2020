package br.com.concrete.testtrainingdecember.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.concrete.testtrainingdecember.utils.PasswordValidator
import br.com.concrete.testtrainingdecember.R
import br.com.concrete.testtrainingdecember.home.HomeActivity

class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    private val loginViewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(PasswordValidator())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginButton = findViewById<View>(R.id.login)
        val emailField = findViewById<EditText>(R.id.email)
        val passwordField = findViewById<EditText>(R.id.password)

        loginViewModel.getViewState().observe(this, {
            when (it) {
                is LoginViewState.Error -> showError(it.errorMessageRes)
                is LoginViewState.Success -> redirectToHome()
            }
        })

        loginButton.setOnClickListener {
            loginViewModel.validateLogin(
                emailField.text.toString(),
                passwordField.text.toString()
            )
        }
    }

    private fun redirectToHome() {
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun showError(@StringRes errorRes: Int) {
        AlertDialog.Builder(this)
            .setMessage(errorRes)
            .show()
    }
}