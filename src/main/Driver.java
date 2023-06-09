package main;

import threadTest.LambdaExpressions;
import threadTest.MyThreadWithRunnable;
import threadTest.MyThreadWithThread;
import threadTest.TimeTest;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        test4();
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

    public static void test3() {
        System.out.println("Main method starting.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Saniyeyi giriniz: ");
        int i = scanner.nextInt();
        TimeTest timeTest = new TimeTest(i);
        Thread thread = new Thread(timeTest);
        Thread thread1 = new Thread(() -> System.out.println("hello"));
        thread.start();
        thread1.start();
        System.out.println("Main method bitiyor.");
    }
    public static void test4 (){
        //lambda expressions kullanımı. Sadece fonksiyonel interface'lerde geçerlidir.
        Thread thread = new Thread(() -> System.out.println("Hello World"));
        thread.start();
    }
}
