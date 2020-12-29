package br.com.concrete.testtrainingdecember

class PasswordValidator {
    private val validations = listOf(
        "[a-z]",
        "[A-Z]",
        "[0-9]",
        "[\\W]",
        "[\\w\\W]{8,}"
    ).map { it.toRegex() }

    fun isValid(password: String) = validations.all { validation ->
        password.contains(validation)
    }
}
