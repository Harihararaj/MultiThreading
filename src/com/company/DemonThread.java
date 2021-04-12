package com.company;
class DemonThread1 implements Runnable{
    public void run(){
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Child Thread");
        }
    }
}
public class DemonThread {
    public static void main(String[] args){
        DemonThread1 demonThread=new DemonThread1();
        Thread thread1=new Thread(demonThread);
        System.out.println(thread1.isDaemon());
        thread1.setDaemon(true);
        thread1.start();
        System.out.println(thread1.isDaemon());
        System.out.println("Main Thread");
    }
}
