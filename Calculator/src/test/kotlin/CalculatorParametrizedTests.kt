import org.example.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import kotlin.test.Test

class CalculatorParametrizedTests {

    private var calculator: Calculator = Calculator()

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/test_add.csv"])
    fun testAdd(firstNumber: Int, secondNumber: Int, expectedResult: Int) {
        val result = calculator.add(firstNumber, secondNumber)
        assertEquals(expectedResult, result)
    }



    @ParameterizedTest
    @CsvFileSource(resources = ["/test_subtract.csv"])
    fun testSubtract(firstNumber: Int, secondNumber: Int, expectedResult: Int) {
        val result = calculator.subtract(firstNumber, secondNumber)
        assertEquals(expectedResult, result)
    }


    @ParameterizedTest
    @CsvFileSource(resources = ["/test_multiply.csv"])
    fun testMultiply(firstNumber: Int, secondNumber: Int, expectedResult: Int) {
        val result = calculator.multiply(firstNumber, secondNumber)
        assertEquals(expectedResult, result)
    }


    @ParameterizedTest
    @CsvFileSource(resources = ["/test_divide.csv"])
    fun testDivide(firstNumber: Int, secondNumber: Int, expectedResult: Int) {
        val result = calculator.divide(firstNumber, secondNumber)
        assertEquals(expectedResult, result)
    }
}