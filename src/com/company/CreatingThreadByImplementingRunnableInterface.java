package com.company;
class MyRunnable implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Iam an child Thread Implemented using Runnable");
        }
        System.out.println(Thread.currentThread());
    }
}
public class CreatingThreadByImplementingRunnableInterface {
    public static void main(String[] args){
        MyRunnable myRunnable=new MyRunnable();
        Thread thread=new Thread(myRunnable,"hari");
        thread.start();
        for(int i=0;i<5;i++){
            System.out.println("Iam an Main Thread");
        }
    }
}
