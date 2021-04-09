package com.company;
class Mythread1 implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().getPriority());
    }

}
public class SettingPriorityAndNameOfTheThread {
    public static void main(String[] args){
        Mythread1 childThread=new Mythread1();
        Thread threadObject=new Thread(childThread);
        System.out.println(Thread.currentThread());
        Thread.currentThread().setName("hari");
        System.out.println(Thread.currentThread());
        threadObject.setName("hara");
        threadObject.setPriority(9);
        threadObject.start();
    }
}
