package org.example


class MailServiceImpl : MailService {
    val recipients = mutableListOf<User>()

    override fun sendMail(to: User) {
        recipients.add(to)
    }
}