package net.dallakyanas.math;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест math.FactorialZeroesCounter
 */
class FactorialZeroesCounterTest {

    /**
     * Негативный тест - передача отрицательного числа
     * Ожидание: {@link InvalidParameterException}
     */
    @Test
    void testNegativeArg() {
        // Arrange
        Long number = -1L;

        // Act/Assert
        assertThrows(InvalidParameterException.class, () -> FactorialZeroesCounter.getLongFactorialZeroesCount(number));
    }

    /**
     * Набор тест-кейсов на вычисление количества нулей в факториале
     *
     * @param number         число, факториал которого мы вычисляем
     * @param expectedResult ожидаемое количество нулей
     */
    @ParameterizedTest
    @CsvSource({
            "0,0", // 1
            "1,0", // 1
            "4,0", // 24
            "5,1", // 120
            "10,2", // 3628800
            "13,4", // 6227020800
            "20,7", // 2432902008176640000
            "26,8", // 403291461126605635584000000
            "42,13", // 1405006117752879898543142606244511569936384000000000
            "50,19", // 30414093201713378043612608166064768844377641568960512000000000000
            "100,30", // 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
    })
    void test(String number, String expectedResult) {
        // Act
        Long actualResult = FactorialZeroesCounter.getLongFactorialZeroesCount(Long.parseLong(number));

        // Assert
        assertEquals(expectedResult, actualResult.toString());
    }

    /**
     * Позитивный тест, что вычисление нулей фактриала не падает для относительно большого числа
     * <p>
     * Ожидание: не выбрасывается никаких исключений
     */
    @Test
    @Disabled
    void noExceptionForBigNumber() {
        Long bigNumber = 12345L;

        assertDoesNotThrow(() -> FactorialZeroesCounter.getLongFactorialZeroesCount(bigNumber));
    }
}