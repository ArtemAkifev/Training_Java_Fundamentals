package com.epam.training.mainTask;

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

public class MainTask {

    private String wordRes;

    public String printHello() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Приветствовать любого пользователя при вводе его имени через командную строку.");
        System.out.println("Введите имя ... ");
        String word = scanner.nextLine();
        System.out.println("Hello " + word);
        this.wordRes = word;
        System.out.println();
        return word;
    }

    public char[] nameRevert() {
        System.out.println("2.Отобразить в окне консоли аргументы командной строки в обратном порядке.\nВвод: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        char[] nameSimbol = word.toCharArray();
        for (int i = nameSimbol.length - 1; i >= 0; i--) {
            System.out.print(nameSimbol[i]);
        }
        System.out.println();
        System.out.println();
        return nameSimbol;

    }

    public void printRandomNumber() {
        System.out.println("3.Вывести заданное количество случайных чисел с переходом и без перехода на новую строку");
        System.out.println("Введите заданное количество случайных чисел ... ");
        int number = 0;
        boolean success = true;
        while (success) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if(number > 0){
                    success = false;
                }else {
                    System.out.println("Число должно быть положительное\nВведите снова: ");
                }
            } else {
                System.out.println("Это не число.\nВведите снова: ");
            }
        }

        for (int i = 0; i < number; i++) {
            int num = (int) (Math.random() * 10) + 1;

            if (num % 2 == 0) {
                System.out.println(num);
            } else {
                System.out.print(num);
            }

        }
        System.out.println();

    }

    public void printInteger() {
        System.out.println();
        System.out.println("4.Ввести целые числа как аргументы командной строки,подсчитать их сумму(произведение) " +
                "и вывести результат на консоль.");
        System.out.println("Введите а: ");
        int a = 0;
        boolean success = true;
        while (success) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                a = scanner.nextInt();
                success = false;
            } else {
                System.out.println("Это не число.\nВведите снова: ");
            }
        }

        System.out.println("Введите b: ");
        int b = 0;
        boolean success1 = true;
        while (success1) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                b = scanner.nextInt();
                success1 = false;
            } else {
                System.out.println("Это не число.\nВведите снова: ");
            }
        }

        int sum = a + b;
        System.out.println("Сумма: а + b = " + sum);

        int multiplication = a * b;
        System.out.println("Произведение: а * b = " + multiplication);
        System.out.println();

    }

    public void mount() {
        System.out.println("5.Ввести число от 1 до 12. Вывести на консоль название месяца,соответствующего " +
                "данному числу.Осуществить проверку корректности ввода чисел.\n");
        Scanner scanner = new Scanner(System.in);

        boolean res = true;
        while (res){
            try {
                int num = scanner.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("January");
                        //res = false; выкл цикл
                        break;
                    case 2:
                        System.out.println("February");
                        break;
                    case 3:
                        System.out.println("March");
                        break;
                    case 4:
                        System.out.println("April");
                        break;
                    case 5:
                        System.out.println("May");
                        break;
                    case 6:
                        System.out.println("June");
                        break;
                    case 7:
                        System.out.println("July");
                        break;
                    case 8:
                        System.out.println("August");
                        break;
                    case 9:
                        System.out.println("September");
                        break;
                    case 10:
                        System.out.println("October");
                        break;
                    case 11:
                        System.out.println("November");
                        break;
                    case 12:
                        System.out.println("December");
                        break;
                    default:
                        System.out.println("Нет месяца под таким номером !!! \nПопробуйте снова : ");
                }

            } catch (Exception e) {
                String a = scanner.nextLine();
                String exit = "exit";
                if(a.equals(exit)){
                    res = false;
                    System.out.println();
                    break;
                }
                System.out.println("Некоректное значение !!! \nПопробуйте снова. \nИли введите exit для выхода.");
            }

        }
    }
}
