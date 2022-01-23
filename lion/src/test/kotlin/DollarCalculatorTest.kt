import calculator.Calculator
import calculator.DollarCalculator
import calculator.MarketApi
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class DollarCalculatorTest {

    @Mock
    lateinit var marketApi: MarketApi

    @BeforeEach
    fun init2(){
        Mockito.lenient().`when`(marketApi.connect()).thenReturn(3000)
    }

    @Test
    fun testHello(){
        println("hello world")
    }

//    @Test
//    fun dollarTest(){
//        println("dollar test")
//        val marketApi = MarketApi()
//        val dollarCalculator = DollarCalculator(marketApi)
//        dollarCalculator.init()
//        val calculator = Calculator(dollarCalculator)
//        println(calculator.sum(10, 20))
//
//        Assertions.assertEquals(33000, calculator.sum(10, 20))
//        Assertions.assertEquals(0, calculator.minus(10, 10))
//    }

    @Test
    fun mockMarketApiTest(){
        println("dollar test")
        val dollarCalculator = DollarCalculator(marketApi)
        dollarCalculator.init()

        val calculator = Calculator(dollarCalculator)
        Assertions.assertEquals(90000, calculator.sum(10, 20))
        Assertions.assertEquals(0, calculator.minus(10, 10))
    }
}