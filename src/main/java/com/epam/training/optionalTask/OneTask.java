package com.epam.training.optionalTask;

import java.util.Scanner;

/** Задание. Ввести n чисел с консоли.
        * 1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
 */

public class OneTask {
    private int numLength = createLengthNum();
    private int[] num = createNumArray();
    private String printAr = printArray();

    private int minValue = minValue(num);
    private int maxValue = maxValue(num);

    private String minValueLength = minValue + "";
    private String maxValueLength = minValue + "";


    private String[] numSt = convertingArrToString(num);
    private String mm = lengthMinMax(numSt);


    public int createLengthNum (){
        System.out.println("OptionalTask1");
        System.out.println("Ввести n чисел с консоли.\n1.Найти самое короткое и самое длинное число." +
                "Вывести найденные числа и их длину.");
        System.out.println("Введите (n) количество чисел : ");
        boolean success = true;
        while (success) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                numLength = scanner.nextInt();
                if (numLength > 0) {
                    success = false;
                } else {
                    System.out.println("Отрицателное значение.\nПопробуйте снова: ");
                    success = true;
                }
            } else {
                System.out.println("Некоректный ввод.\nПопробуйте снова: ");
            }
        }
        return numLength;
    }

    public int[] createNumArray (){
        num = new int[numLength];
        System.out.println("Введите числа");
        boolean success = true;
        while (success) {
            for (int i = 0; i < num.length; i++) {
                System.out.println("Ввод: ");
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    num[i] = scanner.nextInt();
                } else {
                    System.out.println("Это не число: ");
                    --i;
                }
                success = false;
            }
        }
        return num;
    }

    public String printArray(){
        String a = " ";
        System.out.print("Все числа: ");
        for(int i = 0; i < numLength; i++){
            System.out.print(num[i] + a);
        }
        System.out.println();
        return a;
    }




    // 1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    public int minValue (int [] numArray){
        minValue = numArray[0];
        for (int i = 1; i < numArray.length; i++){
            if(numArray[i] < minValue)
                minValue = numArray[i];
        }
        System.out.println(minValue + " минимальное число");
        return minValue;
    }

    public int maxValue (int [] numArray){
        maxValue = numArray[0];
        for (int i = 1; i < numArray.length; i++){
            if(numArray[i] > maxValue)
                maxValue = numArray[i];
        }
        System.out.println(maxValue + " максимальное число");
        return maxValue;
    }

    public String[] convertingArrToString(int[] array){
        String[] numArrayComp = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            numArrayComp [i] = Integer.toString(array[i]);
        }
        return numArrayComp;
    }

    public String lengthMinMax (String[] numSt) {
        //без учета минуса (он не входит в длинну числа);
        String [] bestNumSt = new String[numSt.length];
        for (int i = 0; i < numSt.length ; i++) {
            bestNumSt[i] = numSt[i];
            if (numSt[i].charAt(0) == '-') {
                bestNumSt[i] = numSt[i].substring(1);
            }
        }

        String res = "";
        int min = bestNumSt[0].length();
        int max = 0;
        for(String value : bestNumSt){
            if(value.length() > max){
                max = value.length();
            }
            else if(value.length() < min){
                min = value.length();
            }
        }
        //макс и мин значений может быть несколько поэтому выводим все результаты
        for(int i = 0; i < bestNumSt.length; i++){
            if(bestNumSt[i].length() == max){
                res = "Максимальная длина у числа: " + numSt[i] + ", его длина: " + bestNumSt[i].length();
                System.out.println(res);
            }
            else if(bestNumSt[i].length() == min){
                res = "Минимальная длина у числа: " + numSt[i] + ", его длина: " + bestNumSt[i].length();
                System.out.println(res);
            }
        }
        return res;
    }

}
