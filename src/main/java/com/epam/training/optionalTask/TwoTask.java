package com.epam.training.optionalTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 2.     Вывести числа в порядке возрастания (убывания) значений их длины.
 */
public class TwoTask {

    int numLength = createLengthNum();
    private int[] num = createNumArray();
    String rseNum = printArray();

    String [] convertNum = convertingArrToString(num);
    String [] sortNumFromMore = sortFromMore(convertNum);


    String [] sortNumFromLess = sortFromLess(convertNum);

    public String printArray(){
        String a = " ";
        System.out.print("Все числа: ");
        for(int i = 0; i < numLength; i++){
            System.out.print(num[i] + a);
        }
        System.out.println();
        return a;
    }

    public int createLengthNum (){
        System.out.println();
        System.out.println("Task2");
        System.out.println("2.Вывести числа в порядке возрастания (убывания)" +
                " значений их длины.");
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


    /**
     * конвертируем int[] в String[]
     */
    public String[] convertingArrToString(int[] array){
        String[] numArrayComp = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            numArrayComp [i] = Integer.toString(array[i]);
        }
        return numArrayComp;
    }

    /**
     *использую пузырьковую сортировку
     */
    public String[] sortFromMore (String [] num){
                                                      // отсортированный массив по длине числа (по разрядности),
        String [] bestNumSt = new String[num.length]; // от меньшего к большему

        List<String> list = new ArrayList<>();        // хронит модуль отрицательного числа

        for (int i = 0; i < num.length ; i++) {       // запись в лист
            bestNumSt[i] = num[i];
            if (num[i].charAt(0) == '-') {
                bestNumSt[i] = num[i].substring(1);
                list.add(bestNumSt[i]);
            }
        }

        boolean isSorted = false;
        String xxx = "";
        while(!isSorted) {                                   // сортировка по разрядности
            isSorted = true;
            for (int i = 0; i < bestNumSt.length - 1; i++) {
                if (bestNumSt[i].length() > bestNumSt[i + 1].length()) {
                    xxx = bestNumSt[i];
                    bestNumSt[i] = bestNumSt[i + 1];
                    bestNumSt[i + 1] = xxx;
                    isSorted = false;
                }
            }
        }
     //   System.out.println(Arrays.toString(bestNumSt));

        for (String a : list){
            for(int i = 0; i < bestNumSt.length; i ++){       // проверка отрицательных чисел и их запись в массив
                if(a.equals(bestNumSt[i])){
                    bestNumSt[i] = "-" + bestNumSt[i];
                    break;
                }
            }
        }
        System.out.println("От меньшей длины числа к большей: ");
        System.out.println(Arrays.toString(bestNumSt));
        return bestNumSt;

    }

    public String[] sortFromLess (String [] num){
                                                      // отсортированный массив по длине числа (по разрядности),
        String [] bestNumSt = new String[num.length]; // от меньшего к большему

        List<String> list = new ArrayList<>();        // хронит модуль отрицательного числа

        for (int i = 0; i < num.length ; i++) {       // запись в лист
            bestNumSt[i] = num[i];
            if (num[i].charAt(0) == '-') {
                bestNumSt[i] = num[i].substring(1);
                list.add(bestNumSt[i]);
            }
        }

        for (int i = 0; i < bestNumSt.length - 1; i++){         // сортировка
            for (int j = bestNumSt.length - 1; j > i; j--){
                if(bestNumSt[j-1].length() < bestNumSt[j].length()){
                    String tmp = bestNumSt[j-1];
                    bestNumSt[j-1] = bestNumSt[j];
                    bestNumSt[j] = tmp;
                }
            }
        }
       // System.out.println(Arrays.toString(bestNumSt));
        for (String a : list){
            for(int i = 0; i < bestNumSt.length; i ++){       // проверка отрицательных чисел и их запись в массив
                if(a.equals(bestNumSt[i])){
                    bestNumSt[i] = "-" + bestNumSt[i];
                    break;
                }
            }
        }
        System.out.println("От большей длины числа к меньшей: ");
        System.out.println(Arrays.toString(bestNumSt));
        return bestNumSt;
    }
}
