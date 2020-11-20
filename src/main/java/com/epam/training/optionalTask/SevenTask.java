package com.epam.training.optionalTask;

import java.util.ArrayList;
import java.util.List;

/**
 *  7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
 */

public class SevenTask {
    SixTask sixTask = new SixTask();

    private List<String> allNum = sixTask.getAllNum();

    private List<String> res = search(allNum);

    public List<String> search(List<String> allNum) {

        System.out.println();
        System.out.println("Task7\n7. Найти число, состоящее только из различных цифр. " +
                "Если таких чисел несколько, найти первое из них.");

        List<String> resultList = new ArrayList<>();

        for (String n : allNum) {
            int a = Math.abs(Integer.parseInt(n));
            String p = String.valueOf(a);

            char[] num = p.toCharArray();
            String resNum = "";
            int score = 0;

            for (int i = 0; i < num.length; i++){
                for (int j = 0; j < num.length;){
                    if(num[i] == num[j]){
                        score++;
                    }
                    resNum += num[j];
                    j++;
                }
                if (resNum.length() == num.length * num.length && score == num.length){
                    resultList.add(n);
                }
            }
        }

        if(resultList.isEmpty()){
            System.out.println(allNum.toString() + " - несоответствует условию");
        }else {
            System.out.println("Первое из чисел, состоящее только из различных цифр: " + resultList.get(0));
        }

        return resultList;
    }

}
