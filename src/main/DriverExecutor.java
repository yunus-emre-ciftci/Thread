package main;

import threadTest.ExecutorTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DriverExecutor {
    public static void main(String[] args) {
        //testNewFixedThreadPool();
        //testNewSingleThreadExecutor();
        testNewCachedThreadPool();
    }

    public static void testNewFixedThreadPool() {
        //Executors.newFixedThreadPool(); metodu parametre olarak verilen sayı kadar aynı anda iş yapar.
        //Parametre olarak verilecek maksimum değer işletim sistemine göre değişir.
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        ExecutorTest executorTest = new ExecutorTest();
        //.execute parametre olarak Runnable target alır.
        executorService.execute(executorTest);
        //.submit metodu da parametre olarak hem Runnable hem de Callable target alır. İkisi de aynı işlevi görür.
        executorService.submit(executorTest);

        Thread thread = new Thread(executorTest);
        thread.start();
        executorService.shutdown();


    }


    public static void testNewSingleThreadExecutor() {
        //newSingleThreadExecutor() metodu yalnızca tek bir iş thread için kullanılır. main thread ile aynı işlevi görür.
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorTest executorTest = new ExecutorTest();
        executorService.execute(executorTest);
        Thread thread = new Thread(executorTest);
        thread.start();

    }
    public static void testNewCachedThreadPool(){
        //newCachedThreadPool() metodu ihtiyaç kadar thread oluşturur. Kullanılmayan thread'leri siler.
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorTest executorTest = new ExecutorTest();
        executorService.execute(executorTest);
        Thread thread = new Thread(executorTest);
        thread.start();
        executorService.shutdown();
    }
}

