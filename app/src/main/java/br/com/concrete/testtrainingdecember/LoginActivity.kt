package br.com.concrete.testtrainingdecember

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginButton = findViewById<View>(R.id.login)
        val emailField = findViewById<EditText>(R.id.email)
        loginButton.setOnClickListener {
            if(emailField.text.isEmpty()){
                showErrorEmailIsEmpty()
            }
        }
    }

    private fun showErrorEmailIsEmpty() {
        AlertDialog.Builder(this)
            .setMessage(R.string.error_email_is_empty)
            .show()
    }
}