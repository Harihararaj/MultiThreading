package com.company;
import java.lang.ThreadGroup;
class Threader1 implements Runnable{
    public void run(){
        //System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Threadgroup  {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup tg1=new ThreadGroup("ThreadGroup1");
        ThreadGroup tg2=new ThreadGroup(tg1,"Sub Group");
        Threader1 thread=new Threader1();
        Thread thread1=new Thread(tg1,thread,"one");
        Thread thread2=new Thread(tg1,thread,"two");
        Thread thread3=new Thread(tg1,thread,"three");

        thread1.start();
        thread2.start();
        thread3.start();
        tg1.list();
        System.out.println(tg1.activeCount());
        Thread[] t=new Thread[tg1.activeCount()];
        tg1.enumerate(t);
        for(Thread t1 : t) {
            System.out.println(t1.getName());
        }
        ThreadGroup[] tg3=new ThreadGroup[tg1.activeGroupCount()];
        tg1.enumerate(tg3);
        for(ThreadGroup t1 : tg3) {
            System.out.println(t1.getName());
        }
        System.out.println(tg1.activeGroupCount());


    }
}
