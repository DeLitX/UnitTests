import org.example.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mockito.*
import kotlin.test.Test


class UserMailNotificationBehaviorTest {

    @Test
    fun testPremiumMail() {
        val mailService = mock(MailService::class.java)
        val userRepository = mock(UserRepository::class.java)

        `when`(userRepository.getPremiumUsers()).thenReturn(
            listOf(
                User("Joe", true),
                User("John", true),
            )
        )

        val userMailNotifier = UserMailNotifierImpl(userRepository, mailService)

        userMailNotifier.mailPremiumUsers()

        verify(userRepository).getPremiumUsers()
        verify(mailService).sendMail(User("Joe", true))
        verify(mailService).sendMail(User("John", true))
    }

    @Test
    fun testAllMail() {
        val mailService = mock(MailService::class.java)
        val userRepository = mock(UserRepository::class.java)

        `when`(userRepository.getUsers()).thenReturn(
            listOf(
                User("Joe", true),
                User("John", true),
                User("Jim", false)
            )
        )

        val userMailNotifier = UserMailNotifierImpl(userRepository, mailService)

        userMailNotifier.mailAllUsers()

        verify(userRepository).getUsers()
        verify(mailService).sendMail(User("Joe", true))
        verify(mailService).sendMail(User("John", true))
        verify(mailService).sendMail(User("Jim", false))
    }
}