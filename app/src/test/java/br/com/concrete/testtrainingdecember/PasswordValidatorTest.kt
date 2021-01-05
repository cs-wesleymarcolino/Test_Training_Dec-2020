package br.com.concrete.testtrainingdecember

import br.com.concrete.testtrainingdecember.utils.PasswordValidator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {
    private val passwordValidator = PasswordValidator()

    @Test
    fun givenPasswordShorterThan8_whenValidate_shouldReturnFalse() {
        // arrange

        // act
        val result = passwordValidator.isValid("aA3.567")

        // assert
        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntContainUpperCaseLetter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("aa3.5678av")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntContainLowerCaseLetter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("AA3.5678AV")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntContainNumbers_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("AAx.xxxxdAV")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntContainSpecialCharacter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("Ax3l5678AV")

        assertFalse(result)
    }

    @Test
    fun givenPasswordIsValid_whenValidate_shouldReturnTrue() {
        val result = passwordValidator.isValid("Ax3l.5678AV")

        assertTrue(result)
    }
}