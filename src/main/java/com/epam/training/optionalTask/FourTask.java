package com.epam.training.optionalTask;

import java.util.*;

/**
 * 4.Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
 */

public class FourTask {
    ThirdTask thirdTask = new ThirdTask();
    private String[] convertNum = thirdTask.getConvertNum();

    public String[] getConvertNum() {
        return convertNum;
    }

    private String eee = searchNum(convertNum);

    private int min = Integer.MAX_VALUE;

    public String searchNum(String[] convertNum) {
        System.out.println();
        System.out.println("\nTask4\n4.Найти число, в котором количество различных цифр минимально. " +
                "Если таких чисел несколько, найти первое из них.");

        int[] intNum = new int[convertNum.length];
        for (int i = 0; i < convertNum.length; i++) {
            intNum[i] = Integer.parseInt(convertNum[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer a : intNum) {
            int as = diffNum(Math.abs(a));
            //int time = as;
            if(map.containsKey(as)){
                continue;
            } else {
                map.put(as, a);
            }
        }

        List<Integer> minList = new ArrayList<>();

        for(Map.Entry<Integer, Integer> pair : map.entrySet()){
            int key = pair.getKey();
            minList.add(key);
        }

        Collections.sort(minList);
       // System.out.println();

        for(Map.Entry<Integer, Integer> pair : map.entrySet()){
            int key = pair.getKey();
            int value = pair.getValue();
            if(key == minList.get(0)){
                System.out.println("Минимальное количество различных цифр в числе: " + key + "\n" +
                        "Первое из них: " + value);
            }

        }

        String as = "Yes";
        return as;

    }

    public int diffNum(int x){
        HashSet<Integer> num = new HashSet<>();
        while (x > 0){
            num.add (x % 10);
            x /= 10;
        }
        return num.size();
    }

}

