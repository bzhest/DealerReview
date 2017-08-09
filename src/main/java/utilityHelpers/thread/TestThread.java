package utilityHelpers.thread;

/**
 * Created by Andrey on 18.06.2017.
 */
public class TestThread {
    public static void main(String[] args) {
        new MyThread(750, 10, "First");
        new MyThread(750, 10, "Second");
    }
}
