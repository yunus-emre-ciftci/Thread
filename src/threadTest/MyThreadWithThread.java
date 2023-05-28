package threadTest;

public class MyThreadWithThread extends Thread{
    @Override
    public void run() {
        System.out.println("My thread is running.");
    }
}
