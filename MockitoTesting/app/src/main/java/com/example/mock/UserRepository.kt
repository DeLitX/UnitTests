package com.example.mock

class UserRepository {

    val users = listOf<User>(
        User(1, "Firoz", "firoz@12gmail.com", "Firoz@12"),
        User(2, "Adil", "adil@12gmail.com", "Adil@12"),
        User(3, "Arshaman", "arsh@gmail.com", "arsh@12")
    )

    fun checkIfEmailAvailable(email: String): Boolean {
        return users.any { user -> user.email == email }
    }

    fun loginUser(email: String, password: String): LOGIN_STATUS {
        // Fetch user from DB
        val user = users.filter { user -> user.email == email }
        return if (users.size == 1) {
            if (users[0].password == password) {
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        } else {
            LOGIN_STATUS.INVALID_USER
        }
    }
}