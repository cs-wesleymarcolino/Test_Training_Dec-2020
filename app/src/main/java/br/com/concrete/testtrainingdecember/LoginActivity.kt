package br.com.concrete.testtrainingdecember

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity(R.layout.activity_login) {
    private val passwordValidator = PasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginButton = findViewById<View>(R.id.login)
        val emailField = findViewById<EditText>(R.id.email)
        val passwordField = findViewById<EditText>(R.id.password)
        loginButton.setOnClickListener {
            when {
                emailField.text.isEmpty() -> showError(R.string.error_email_is_empty)
                passwordField.text.isEmpty() -> showError(R.string.error_password_is_empty)
                !passwordValidator.isValid(passwordField.text.toString()) -> {
                    showError(R.string.error_password_is_invalid)
                }
                else -> {
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun showError(@StringRes errorRes: Int) {
        AlertDialog.Builder(this)
            .setMessage(errorRes)
            .show()
    }
}