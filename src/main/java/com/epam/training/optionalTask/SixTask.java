package com.epam.training.optionalTask;

import java.util.ArrayList;
import java.util.List;

/**
 * 6.Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое
 *   из них.
 */
public class SixTask {
    FiveTask fiveTask = new FiveTask();
    private List<String> allNum = fiveTask.getListMix();

    public List<String> getAllNum() {
        return allNum;
    }

    private List<String> res = search(allNum);

    public List<String> search(List<String> allNum){

        System.out.println();
        System.out.println("\nTask6\n6.Найти число, цифры в котором идут в строгом порядке возрастания. " +
                "Если таких чисел несколько, найти первое из них.");

        List<String> resultList = new ArrayList<>();

        for(String n : allNum) {
            int a = Math.abs(Integer.parseInt(n));
            String p = String.valueOf(a);

            char[] num = p.toCharArray();
            String resNum = String.valueOf(num[0]);
            int score = 1;

            for (int i = 1; i < num.length; i++){
                if(num[i] - num[0] == score){
                    resNum += String.valueOf(num[i]);
                    score++;
                }

                if (resNum.length() == num.length){
                    resultList.add(n);
                    score = 1;
                }
            }
        }

        if(resultList.isEmpty()){
            System.out.println(allNum.toString() + " - несоответствует условию");
        }else {
            System.out.println("ПЕРВОЕ из чисел, в котором идет строгий порядок возрастания: " + resultList.get(0));
        }

        return resultList;
    }

}
