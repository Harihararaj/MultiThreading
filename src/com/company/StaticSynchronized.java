package com.company;
class Display1{
    public static synchronized void wish(String name){
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
class MyThread3 implements Runnable{
    Display1 objectToDisplay;
    String name;
    MyThread3(Display1 objectToDisplay,String name){
        this.objectToDisplay=objectToDisplay;
        this.name=name;
    }
    public void run(){
        objectToDisplay.wish(name);
    }
}
public class StaticSynchronized {
    public static void main(String[] args) {
        Display1 d = new Display1();
        MyThread3 childThread1 = new MyThread3(d, "hari");
        Thread thread = new Thread(childThread1);
        Display1 d1 = new Display1();
        MyThread3 childThread2 = new MyThread3(d1, "kamal");
        Thread thread1 = new Thread(childThread2);
        thread.start();
        thread1.start();
    }
}
