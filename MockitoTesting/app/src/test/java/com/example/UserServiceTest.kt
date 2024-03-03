package com.example

import com.example.mock.LOGIN_STATUS
import com.example.mock.UserRepository
import com.example.mock.UserService
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    private lateinit var service: UserService

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
        Mockito.`when`(userRepository.loginUser("testEmail@gmail.com", "testPassword")).thenReturn(LOGIN_STATUS.SUCCESS)
        Mockito.`when`(userRepository.checkIfEmailAvailable(anyString())).thenReturn(true)
        Mockito.`when`(userRepository.checkIfEmailAvailable("testEmail@gmail.com")).thenReturn(false)
        service = UserService(userRepository)
    }

    @Test
    fun testLoginFailed() {
        val status = service.loginUser("abc@gmail.com", "111111")
        Assert.assertEquals("Password is invalid", status)
    }

    @Test
    fun testLoginSuccess() {
        val status = service.loginUser("testEmail@gmail.com", "testPassword")
        Assert.assertEquals("Logged in successfully", status)
    }

    @Test
    fun testEmailFree() {
        val status = service.checkIfEmailAvailable("abc@gmail.com")
        Assert.assertEquals("Email is available", status)
    }

    @Test
    fun testEmailTaken() {
        val status = service.checkIfEmailAvailable("testEmail@gmail.com")
        Assert.assertEquals("Email is taken", status)
    }
}