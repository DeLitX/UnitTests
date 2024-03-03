package org.example

class UserMailNotifierImpl(private val userRepository: UserRepository, private val mailService: MailService) :
    UserMailNotifier {
    override fun mailPremiumUsers() {
        userRepository.getPremiumUsers().forEach { user ->
            mailService.sendMail(user)
        }
    }

    override fun mailAllUsers() {
        userRepository.getUsers().forEach { user ->
            mailService.sendMail(user)
        }
    }
}