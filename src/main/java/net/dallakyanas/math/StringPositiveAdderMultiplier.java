package net.dallakyanas.math;

/**
 * Класс, реализующий операции сложения и перемножение двух положительных чисел "в столбик".
 * Предполагается, что проверка аргументов, на то,что строка представляет положительное число уже произведена.
 */
public class StringPositiveAdderMultiplier {
    /**
     * Сложение двух строковых представлений чисел "в столбик"
     *
     * @param arg1 первое число
     * @param arg2 второе число
     * @return строковое представление результата сложения
     */
    public static String add(String arg1, String arg2) {
        // Определить самое "длинное" число, оно станет первым аргументом
        String a = arg1.length() >= arg2.length() ? arg1 : arg2;
        String b = a == arg1 ? arg2 : arg1;

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int lengthA = a.length();
        int lengthB = b.length();

        int memory = 0; // цифра "в уме"
        int digitA = 0; // очередная цифра из числа-первого аргумента
        int digitB = 0; // очередная цифра из числа-второго аргумента
        int result = 0; // промежуточный результат сложения

        StringBuilder resultString = new StringBuilder();

        // сложить "в столбик" цифры второго числа с первым
        for (int i = 0; i < lengthB; i++) {
            digitA = a.charAt(i) - '0';
            digitB = b.charAt(i) - '0';

            result = digitA + digitB + memory;

            memory = result / 10;
            resultString.append(result % 10);
        }

        // прибавить к оставшейся части первого числа значение цифра "в уме"
        for (int i = lengthB; i < lengthA; i++) {
            digitA = a.charAt(i) - '0';
            digitB = memory;

            result = digitA + digitB;

            memory = result / 10;
            resultString.append(result % 10);
        }

        if (memory > 0) {
            resultString.append(memory);
        }

        return resultString.reverse().toString();
    }

    /**
     * Перемножение двух строковых представлений чисел "в столбик"
     *
     * @param arg1 первое число
     * @param arg2 второе число
     * @return строковое представление результата перемножения
     */
    public static String multiply(String arg1, String arg2) {
        // Определить самое "короткое" число, оно станет первым аргументом
        String a = arg1.length() <= arg2.length() ? arg1 : arg2;
        String b = a == arg1 ? arg2 : arg1;

        a = new StringBuilder(a).reverse().toString();

        int lengthA = a.length();
        int digitA = 0; // очередная цифра из числа-первого аргумента
        StringBuilder zeroTail = new StringBuilder(""); // десятичный мультипликатор для очередного разряда

        String resultString = "0";

        for (int i = 0; i < lengthA; i++) {
            digitA = a.charAt(i) - '0';
            String r = multiplyOneDigit(digitA, b);

            resultString = add(resultString, r + zeroTail.toString());
            zeroTail.append("0");
        }

        return resultString;
    }

    /**
     * Перемножение одноразрядного числа на число произвольного размера
     *
     * @param digit цифра
     * @param arg   второе число
     * @return строковое представление результата переменожения
     */
    private static String multiplyOneDigit(int digit, String arg) {
        String a = new StringBuilder(arg).reverse().toString();
        int lengthA = a.length();

        int memory = 0; // число "в уме"
        int argDigit = 0; // очередная цифра из числа-первого аргумента
        int result = 0; // промежуточный результат перемножения

        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < lengthA; i++) {
            argDigit = a.charAt(i) - '0';

            result = argDigit * digit + memory;

            memory = result / 10;
            resultString.append(result % 10);
        }

        if (memory > 0) {
            resultString.append(memory);
        }

        return resultString.reverse().toString();
    }
}
