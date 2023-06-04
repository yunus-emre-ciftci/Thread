package threadTest;

import java.util.concurrent.TimeUnit;

public class TimeTest implements Runnable {
    private int seconds;

    public TimeTest(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        System.out.println("Thread başladı.");
        try {
            //17.satır parametre olarak verilen sayı kadar saniye döner.
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread bitti.");
    }
}
