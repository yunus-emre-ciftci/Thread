package main;

import threadTest.MyThreadWithThread;

public class Driver {
    public static void main(String[] args) {
        MyThreadWithThread myThreadWithThread = new MyThreadWithThread();
        myThreadWithThread.run();
    }
}
