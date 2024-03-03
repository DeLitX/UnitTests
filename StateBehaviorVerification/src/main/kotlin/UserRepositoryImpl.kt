package org.example

class UserRepositoryImpl : UserRepository {
    val actualUsers = mutableListOf<User>()

    override fun getUsers(): List<User> {
        return actualUsers
    }

    override fun getPremiumUsers(): List<User> {
        return actualUsers.filter { it.isPremium }
    }
}