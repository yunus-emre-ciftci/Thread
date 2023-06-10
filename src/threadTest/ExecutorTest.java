package threadTest;

public class ExecutorTest implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());


    }
}
