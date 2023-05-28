package main;

import threadTest.MyThreadWithThread;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
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
}
