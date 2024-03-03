package com.example.mock

import com.example.mock.LOGIN_STATUS.*

class UserService(private val userRepository: UserRepository) {

    fun checkIfEmailAvailable(email: String): String {
        return if (userRepository.checkIfEmailAvailable(email)) {
            "Email is available"
        } else {
            "Email is taken"
        }
    }

    fun loginUser(email: String, password: String): String {
        val status = userRepository.loginUser(email, password)
        return when (status) {
            INVALID_USER -> "User does not exist"
            INVALID_PASSWORD -> "Password is invalid"
            UNKNOWN_ERROR -> "Unknown error occurred"
            SUCCESS -> "Logged in successfully"
        }
    }
}