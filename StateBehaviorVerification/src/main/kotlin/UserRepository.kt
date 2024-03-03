package org.example

interface UserRepository {
    fun getUsers(): List<User>
    fun getPremiumUsers(): List<User>
}