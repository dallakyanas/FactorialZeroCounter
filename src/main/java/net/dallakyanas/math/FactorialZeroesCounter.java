package net.dallakyanas.math;

import java.security.InvalidParameterException;

/**
 * Класс, реализующий функционал подсчитывания количества нулей факториала любого числа.
 * <p>
 * Факториа́л — функция, определённая на множестве неотрицательных целых чисел. Название происходит от лат.
 * factorialis — действующий, производящий, умножающий; обозначается n!, произносится эн факториа́л. Факториал
 * натурального числа n определяется как произведение всех натуральных чисел от 1 до n включительно
 * 0! = 1
 */
public class FactorialZeroesCounter {
    /**
     * Функция, вычисляющая факториал числа. Использует {@link StringPositiveAdderMultiplier} для операции произведения.
     *
     * @param number число, факториал которого необходимо вычислить
     * @return строковое представление вычисленного факториала
     */
    public static String getStringFactorial(long number) {
        if (number < 0) {
            throw new InvalidParameterException("Факториал может быть вычислен только над неотрицательным числом!");
        }

        String factorial = "1";

        if (number > 0) {
            for (long i = 1L; i <= number; i++) {
                factorial = StringPositiveAdderMultiplier.multiply(factorial, Long.toString(i));
            }
        }

        return factorial;
    }

    public static Long getLongFactorialZeroesCount(Long number) {
        String factorial = getStringFactorial(number);

        // подсчитать количество нулей в строке
        return factorial.chars().filter(ch -> ch == '0').count();
    }
}
