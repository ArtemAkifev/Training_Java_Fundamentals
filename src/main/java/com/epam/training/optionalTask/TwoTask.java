package com.epam.training.optionalTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2.     Вывести числа в порядке возрастания (убывания) значений их длины.
 */
public class TwoTask {
    OneTask one = new OneTask();
    private String[] convertNum = one.getNumSt();

    public String[] getConvertNum() {
        return convertNum;
    }

    private String [] sortNumFromMore = sortFromMore(convertNum);
    private String [] sortNumFromLess = sortFromLess(convertNum);

    /**
     *использую пузырьковую сортировку
     */

    public String[] sortFromMore (String [] num){
        System.out.println("\nTask2\n2.Вывести числа в порядке возрастания (убывания) значений их длины.");

                                                      // отсортированный массив по длине числа (по разрядности),
        String [] bestNumSt = new String[num.length]; // от меньшего к большему

        List<String> list = new ArrayList<>();        // хранит модуль отрицательного числа

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
