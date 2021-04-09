package com.company;
class Display{
    public synchronized void wish(String name){
        for(int i=0;i<5;i++){
            System.out.print("Good Morning :");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
    }

}
class MyThread2 implements Runnable{
    Display objectToDisplay;
    String name;
    MyThread2(Display objectToDisplay,String name){
        this.objectToDisplay=objectToDisplay;
        this.name=name;
    }
    public void run(){
        objectToDisplay.wish(name);
    }
}
public class Synchronization {
    public static void main(String[] args){
        Display d=new Display();
        MyThread2 childThread1=new MyThread2(d,"hari");
        Thread thread=new Thread(childThread1);
        MyThread2 childThread2=new MyThread2(d,"kamal");
        Thread thread1=new Thread(childThread2);
        thread.start();
        thread1.start();
    }
}
