package br.com.concrete.testtrainingdecember

import org.junit.Assert
import org.junit.Test

class PasswordValidatorTest {
    private val passwordValidator = PasswordValidator()

    @Test
    fun givenPasswordShorterThan8_whenValidate_shouldReturnFalse() {
        // arrange

        // act
        val result = passwordValidator.isValid("1234567")

        // assert
        Assert.assertFalse(result)
    }
}