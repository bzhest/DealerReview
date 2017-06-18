package utility.thread;

/**
 * Created by Andrey on 18.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        new MyThread(750, 10, "First");
        new MyThread(1000, 10, "Second");

    }


}
