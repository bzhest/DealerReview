package com.example.logHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrey on 13.04.2017.
 */
public abstract class LogBase {

    public abstract void log(String msg);
    protected  String currentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        return sdf.format(new Date());
    }

}
