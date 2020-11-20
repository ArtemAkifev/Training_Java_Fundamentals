package com.epam.training.optionalTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5.Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом
 * четных и нечетных цифр.
 */
public class FiveTask {
    FourTask fourTask = new FourTask();
    private String[] convertNum = fourTask.getConvertNum();

    private List<String> listEvenNum = evenNumber(convertNum); // четные

    private List<String> listMix = Arrays.asList(convertNum.clone()); // все

    public List<String> getListMix() {
        return listMix;
    }

    private List<String> remains = mix(listMix); // остатки

    private List<String> equality = resultEquality(remains);


    public List<String> evenNumber (String[] convertNum){
        System.out.println();
        System.out.println("Task5\n5.Найти количество чисел, содержащих только четные цифры, " +
                "а среди оставшихся — количество чисел с равным числом\n" +
                " * четных и нечетных цифр.");

        List<String> listEvenNum = new ArrayList<>();

        for(String n : convertNum) {
            int score = 0;
            int k = Math.abs(Integer.parseInt(n));
            String p = String.valueOf(k);

            char[] o = p.toCharArray();
                for (int i = 0; i < o.length; i++){
                    String s = String.valueOf(o[i]);
                    int a = Integer.parseInt(s);
                if (a % 2 == 0) {
                    score ++;
                    if(score == o.length) {
                        listEvenNum.add(n);
                    }
                }
            }
        }

        System.out.println("Количество чисел, содержащих только четные цифры: " + listEvenNum.size());

        for (String a : listEvenNum){
            System.out.print(a + " ");
        }
        System.out.println();
        return listEvenNum;
    }

    public List<String> mix (List<String> listMix){
        List<String> resList = new ArrayList<>(listMix);
        for(String a : listMix){
            if (listEvenNum.contains(a)){
                resList.remove(a);
            }
        }
       // System.out.println(resList.toString() + " - оставшиеся");
        return resList;
    }

    public List<String> resultEquality (List<String> listMix){
        int even = 0;
        int odd = 0;

        List<String> fullList = new ArrayList<>();

        for(String n : listMix){
            boolean yes = true;
            int k = Math.abs(Integer.parseInt(n));
            String p = String.valueOf(k);
            char[] num = p.toCharArray();

            for(int i = 0; i < num.length && yes; i++){
                if(num.length % 2 == 0) {
                    if (num[i] % 2 == 0) {
                        even++;
                    } else {
                        odd++;
                    }
                } else {
                    yes = false;
                }
            }

            boolean fok = true;

            if (even == 0){
                fok = false;
            }
            if (even == odd && fok){
                fullList.add(n);
                even = 0;
                odd = 0;
            }
        }
        System.out.println("Среди оставшихся — количество чисел с равным числом " +
                "* четных и нечетных цифр: " + fullList.size());
        for (String a : fullList){
            System.out.print(a + " ");
        }

        return fullList;
    }

}
