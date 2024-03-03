import org.example.MailServiceImpl
import org.example.User
import org.example.UserMailNotifierImpl
import org.example.UserRepositoryImpl
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test


class UserMailNotificationStateTest {

    @Test
    fun testPremiumMail() {
        val mailService = MailServiceImpl()
        val userRepository = UserRepositoryImpl()

        userRepository.actualUsers.add(User("Joe", true))
        userRepository.actualUsers.add(User("John", true))
        userRepository.actualUsers.add(User("Jim", false))

        val userMailNotifier = UserMailNotifierImpl(userRepository, mailService)

        userMailNotifier.mailPremiumUsers()

        assertEquals(2, mailService.recipients.size)
        assertEquals(
            listOf(
                User("Joe", true),
                User("John", true)
            ),
            mailService.recipients
        )
    }

    @Test
    fun testAllMail() {
        val mailService = MailServiceImpl()
        val userRepository = UserRepositoryImpl()

        userRepository.actualUsers.add(User("Joe", true))
        userRepository.actualUsers.add(User("John", true))
        userRepository.actualUsers.add(User("Jim", false))

        val userMailNotifier = UserMailNotifierImpl(userRepository, mailService)

        userMailNotifier.mailAllUsers()

        assertEquals(3, mailService.recipients.size)
        assertEquals(
            listOf(
                User("Joe", true),
                User("John", true),
                User("Jim", false)
            ),
            mailService.recipients
        )
    }
}