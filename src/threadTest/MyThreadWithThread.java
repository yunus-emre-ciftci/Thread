package threadTest;

import java.util.Scanner;

public class MyThreadWithThread extends Thread{
    @Override
    public void run() {
        System.out.println("My thread is starting.");
        try {
            //.sleep için yazılan milisaniye tipinde bir long sayı girildiğinde o süre kadar işlem bekletilir.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("My thread is running.");
    }
}
