package com.example.logHelper;

import java.io.FileWriter;

/**
 * Created by Andrey on 13.04.2017.
 */
public  class FileLogger extends LogBase {


    @Override
    public void log(String msg) {
        String curProcess = Thread.currentThread().getName();


        try {
            FileWriter file = new FileWriter("report.txt", true);
            file.append(System.lineSeparator() + stepCounter + ")" +currentTime() + " [" + curProcess + "] " + msg);
            stepCounter++;
            file.close();
        } catch (Exception ex) {
        }
    }
}