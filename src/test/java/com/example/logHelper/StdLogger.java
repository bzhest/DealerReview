package com.example.logHelper;

/**
 * Created by Andrey on 13.04.2017.
 */
public class StdLogger extends LogBase{


    static int stepCounter = 1;
    @Override
    public void log(String msg) {
        String curProcess = Thread.currentThread().getName();
        System.out.println(stepCounter + ")" +currentTime() + " [" + curProcess + "] " + msg);
        stepCounter++;
    }
}
