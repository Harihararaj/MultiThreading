package com.company;
class Runable implements Runnable{
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println(i);
        }
    }
}
public class CallingRunMethod {
    public static void main(String[] args){
        Runable r=new Runable();
        Thread thread1=new Thread(r);
        Thread thread2=new Thread(r);
        thread1.run();
        thread2.run();
    }
}
