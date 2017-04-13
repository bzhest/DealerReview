package com.example.logHelper;

import java.io.FileWriter;

/**
 * Created by Andrey on 13.04.2017.
 */
public  class FileLogger extends LogBase {
    @Override
    public void log(String msg) {
        try {
            FileWriter file = new FileWriter("report.txt", true);
            file.append(System.lineSeparator() + msg);
            file.close();
        } catch (Exception ex) {
        }
    }
}