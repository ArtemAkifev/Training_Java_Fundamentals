package com.epam.training.optionalTask;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
 */

public class ThirdTask {
    TwoTask twoTask = new TwoTask();
    private String[] convertNum = twoTask.getConvertNum();

    public String[] getConvertNum() {
        return convertNum;
    }

    private double mediumLength = searchMediumLength(convertNum);

    private String[] numFromMore = fromMore(convertNum);
    private String[] numFromLess = fromLess(convertNum);

    public double searchMediumLength(String[] convertNum) {
        System.out.println("\nTask3\n3.Вывести на консоль те числа, длина которых меньше (больше) " +
                "средней длины по всем числам, а также длину.");

        String[] bestNumSt = new String[convertNum.length];

        List<String> list = new ArrayList<>();        // хранит модуль отрицательного числа

        for (int i = 0; i < convertNum.length; i++) {       // запись в лист
            bestNumSt[i] = convertNum[i];
            if (convertNum[i].charAt(0) == '-') {
                bestNumSt[i] = convertNum[i].substring(1);
                list.add(bestNumSt[i]);
            }
        }

        double value = 0;

        for (String n : bestNumSt) {
            value += n.length();
        }

        double mediumLength = value / convertNum.length;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String result = decimalFormat.format(mediumLength);

        System.out.print("Средняя длина: " + result + "\n");

        return mediumLength;
    }

    public String[] fromMore(String[] convertNum) {
        String[] bestNumSt = new String[convertNum.length];

        List<String> list = new ArrayList<>();        // хранит модуль отрицательного числа

        for (int i = 0; i < convertNum.length; i++) {       // запись в лист
            bestNumSt[i] = convertNum[i];
            if (convertNum[i].charAt(0) == '-') {
                bestNumSt[i] = convertNum[i].substring(1);
                list.add(bestNumSt[i]);
            }
        }


        System.out.print("Числа с длиной меньше среднего: ");
        for (String n : bestNumSt) {
            if (n.length() < mediumLength) {
                if(list.contains(n)){
                    System.out.print("-" + n + " ");
                }else {
                    System.out.print(n + " ");
                }
            }
        }

        return bestNumSt;
    }

    public String[] fromLess(String[] convertNum) {
        String[] bestNumSt = new String[convertNum.length];

        List<String> list = new ArrayList<>();        // хранит модуль отрицательного числа

        for (int i = 0; i < convertNum.length; i++) {       // запись в лист
            bestNumSt[i] = convertNum[i];
            if (convertNum[i].charAt(0) == '-') {
                bestNumSt[i] = convertNum[i].substring(1);
                list.add(bestNumSt[i]);
            }
        }


        System.out.print("\nЧисла с длиной больше среднего: ");
        for (String n : bestNumSt) {
            if (n.length() > mediumLength) {
                if(list.contains(n)){
                    System.out.print("-"+n + " ");
                }else {
                    System.out.print(n + " ");
                }
            }
        }

        return bestNumSt;
    }

}
