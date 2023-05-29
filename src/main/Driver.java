package main;

import threadTest.MyThreadWithRunnable;
import threadTest.MyThreadWithThread;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        //test1();
        test2();

    }

    public static void test1() {
        //Yeni bir MyThread objesi oluşturuldu.
        MyThreadWithThread myThreadWithThread = new MyThreadWithThread();
        System.out.println("Start.");

        //.run ile normal bir metot çağırmış gibi çağırım yaparız. Thread mantığıyla bir işlem yapılmaz. Sırayla yapılır.
        //myThreadWithThread.run();

        //.start metodu yeni bir thread objesi oluşturulur ve JVM referans objenin sınıfındaki run() metodunu çalıştırır.
        // Alt satırlar bu aşamada .run() metodunun içindeki işlemlerin bitmesini beklemez. Çalışmaya başlarlar.
        //.run içindeki işlemlerde asenkron şekilde çalışmaya başlar hangisi önce biterse ekrana o yazdırılır.
        //.start metodunu iki kez çağıramazsınız. Birden fazla çalıştırmak isterseniz
        // referans ettiği objenin sınıfını yeniden oluşturmamız gerekiyor. (myThreadWithThread = new MyThreadWithThread)
        myThreadWithThread.start();

        System.out.println("Finished.");
    }

    public static void test2() {
        //Runnable'ı implement eden kendi Thread sınıfımız doğru olan Thread kullanımıdır.
        MyThreadWithRunnable myThreadWithRunnable = new MyThreadWithRunnable();
        //myThreadWithRunnable doğrudan Thread sınıfının metotlarına erişemediği için bir Thread objesi oluşturuyoruz.
        //parametre olarak Runnable objesi verebildiğimiz için myThreadWithRunnable objesini veriyoruz.
        Thread thread = new Thread(myThreadWithRunnable);
        System.out.println("My main is starting.");
        //Şimdi Thread sınıfının metotlarına erişebiliriz.
        thread.start();
        System.out.println("My main is ending.");
    }
}
