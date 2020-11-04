package com.epam.training;

import com.epam.training.mainTask.MainTask;
import com.epam.training.optionalTask.OptionalTask1;

import java.io.IOException;

public class App
{

    public static void main(String[] args) throws IOException {
        MainTask task1 = new MainTask();
        task1.printHello();
        task1.nameRevert();
        task1.printRandomNumber();
        task1.printInteger();
        task1.mount();

        OptionalTask1 optionalTask1 = new OptionalTask1();

    }

}
