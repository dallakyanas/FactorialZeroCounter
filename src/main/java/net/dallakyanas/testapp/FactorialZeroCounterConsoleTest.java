package net.dallakyanas.testapp;

import net.dallakyanas.math.FactorialZeroesCounter;

import java.util.Scanner;

public class FactorialZeroCounterConsoleTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Long x = 0L;
        String s = "";

        while (true) {
            System.out.println("Для вычисления количества нулей факториала введите число ('q' для выхода):");

            s = scan.next();

            if ("q".equals(s)) {
                break;
            }

            try {
                x = Long.parseLong(s);

                System.out.printf("В факториале числа %S содержится %s нулей %n",
                        x,
                        FactorialZeroesCounter.getLongFactorialZeroesCount(x));
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            } catch (Exception e) {
                System.out.println("Произошла ошибка при попытке вычисления количества нулей в факториале:\n" + e);
            }

        }
        System.out.println("До свидания!");
    }
}
