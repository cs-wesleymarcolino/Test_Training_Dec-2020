package br.com.concrete.testtrainingdecember

class PasswordValidator {
    fun isValid(password: String): Boolean {
        return password.length >= 8
    }
}
