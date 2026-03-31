package utility;

import drivers.BaseTest;

public class CommonMethod extends BaseTest {
    public static void timeout() throws InterruptedException {
        Thread.sleep(3000);
    }

    public static void timeout(int time) throws InterruptedException {
        Thread.sleep(time);
    }
}