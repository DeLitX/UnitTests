import org.example.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class CalculatorTests {

    private var calculator: Calculator = Calculator()

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun testAddPositive() {
        val result = calculator.add(2, 3)
        assertEquals(5, result)
    }

    @Test
    fun testAddNegative() {
        val result = calculator.add(2, -3)
        assertEquals(-1, result)
    }

    @Test
    fun testSubtractPositive() {
        val result = calculator.subtract(5, 3)
        assertEquals(2, result)
    }

    @Test
    fun testSubtractNegative() {
        val result = calculator.subtract(5, -3)
        assertEquals(8, result)
    }

    @Test
    fun testMultiplyPositive() {
        val result = calculator.multiply(2, 3)
        assertEquals(6, result)
    }

    @Test
    fun testMultiplyNegative() {
        val result = calculator.multiply(2, -3)
        assertEquals(-6, result)
    }

    @Test
    fun testDividePositive() {
        val result = calculator.divide(6, 3)
        assertEquals(2, result)
    }

    @Test
    fun testDivideNegative() {
        val result = calculator.divide(6, -3)
        assertEquals(-2, result)
    }
}