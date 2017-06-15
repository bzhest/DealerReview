package utility.logger;

import utility.ConfigurationManager;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SYSTEM on 20.04.2017.
 */
public class StdLogger implements LogBaseNew {

    private ConfigurationManager manager;

    public StdLogger(ConfigurationManager manager){this.manager = manager;}

    public static int stepCounter = 1;

    protected  String currentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        return sdf.format(new Date());
    }

    @Override
    public void log(String msg) {
        String curProcess = Thread.currentThread().getName();
        System.out.println(stepCounter + ")" +currentTime() + " [" + curProcess + "] " + msg);
        stepCounter++;
    }
}
