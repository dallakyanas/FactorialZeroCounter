package net.dallakyanas.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тест для math.StringPositiveAdderMultiplier
 */
class StringPositiveAdderMultiplierTest {

    /**
     * Набор тест-кейсов на перемножение двух чисел
     *
     * @param arg1           первое число
     * @param arg2           второе число
     * @param expectedResult ожидаемый результат перемножения
     */
    @ParameterizedTest
    @CsvSource({
            "0,0,0",
            "0,1,0",
            "1,0,0",
            "5,1,5",
            "1,5,5",
            "2,2,4",
            "6,4,24",
            "343,22,7546",
            "379,22,8338",
            "123,123,15129",
            "12345678,12345678,152415765279684",
            "123456789,123456789,15241578750190521",
            "1234567890,1234567890,1524157875019052100",
            "1234567890,123456789,152415787501905210",
            "1234567891,1234567892,1524157878722755772",
    })
    void testMultiply(String arg1, String arg2, String expectedResult) {
        // Act
        String actualResult = StringPositiveAdderMultiplier.multiply(arg1, arg2);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Набор тест-кейсов на сложение двух чисел
     *
     * @param arg1           первое число
     * @param arg2           второе число
     * @param expectedResult ожидаемый результат сложения
     */
    @ParameterizedTest
    @CsvSource({
            "0,0,0",
            "0,1,1", "1,0,1",
            "0,123,123", "123,0,123",
            "2,12,14", "12,2,14",
            "9,12,21", "12,9,21",
            "88,98,186", "98,88,186",
            "342,12,354", "12,342,354",
            "686,6860,7546",
            "123456,1234,124690",
            "1234567890,1234567890,2469135780",

            "0,111111101,111111101",
            "111111101,9876543120,9987654221",
            "9987654221,86419752300,96407406521",
            "96407406521,740740734000,837148140521",
            "837148140521,6172839450000,7009987590521",
            "7009987590521,49382715600000,56392703190521",
            "56392703190521,370370367000000,426763070190521",
            "426763070190521,2469135780000000,2895898850190521",
            "2895898850190521,12345678900000000,15241577750190521",

    })
    void testAdd(String arg1, String arg2, String expectedResult) {
        // Act
        String actualResult = StringPositiveAdderMultiplier.add(arg1, arg2);

        // Assert
        assertEquals(expectedResult, actualResult);
    }
}