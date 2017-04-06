package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrey on 30.03.2017.
 */
public class Logger {
    private int counter = 1;

    public void log(String msg){
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        String time = sdf.format(new Date());

        String currentProcess = Thread.currentThread().getName();
        System.out.println(counter + ")" + time + "[ " + currentProcess + "] "+ msg);
        counter++;

    }
}
