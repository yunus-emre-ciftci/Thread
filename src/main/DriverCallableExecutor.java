package main;

import threadTest.CallableThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DriverCallableExecutor {
    public static void main(String[] args) {
        CallableThread callableThread = new CallableThread();
        //Tek bir thread ile işlem yapacağım için newSingleThreadExecutor kullandım.
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //.submit metodu geriye Future döndürür.
        Future<Integer> future = executorService.submit(callableThread);
        try {
            //.get metodu Future nesnelerinin sonucunu fırlatır.
            Integer integer =  future.get();
            System.out.println(integer);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            //Exception almamak  için finally bloklarının arasında executor service'i kapattık.
            executorService.shutdown();
        }
    }
}
