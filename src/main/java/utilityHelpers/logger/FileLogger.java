package utilityHelpers.logger;


import utilityHelpers.logger.api.LogBaseNew;


import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SYSTEM on 20.04.2017.
 */
public class FileLogger implements LogBaseNew {


    public static int stepCounter = 1;

    protected  String currentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        return sdf.format(new Date());
    }

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

