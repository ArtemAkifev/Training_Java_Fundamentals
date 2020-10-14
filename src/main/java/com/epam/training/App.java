package com.epam.training;

import com.epam.training.mainTask.MainTask;
import com.epam.training.mainTask.MainTask2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 *
        *Реализовать следующие программы:
        *1.Приветствовать любого пользователя при вводе его имени через командную строку.
        *2.Отобразить в окне консоли аргументы командной строки в обратном порядке.
        *3.Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
        *4.Ввести целые числа как аргументы командной строки,подсчитать их сумму(произведение)
        *и вывести результат на консоль.
        *5.Ввести число от 1до 12.Вывести на консоль название месяца,соответствующего данному
        *числу.Осуществить проверку корректности ввода чисел.
 **/

public class App
{

    public static void main(String[] args) throws IOException {
        MainTask task1 = new MainTask();
        task1.printHello();
        task1.nameRevert();
        task1.printRandomNumber();
        task1.printInteger();
        task1.mount();
    }

}
