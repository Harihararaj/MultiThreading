package com.company;
class Mythread extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Iam Child Thread");
        }
    }
}
public class CreationOfThreadByExtendingThreadClass {
    public static void main(String[] args){
        Mythread myThread=new Mythread();
        myThread.start();
        for(int i=0;i<5;i++){
            System.out.println("Iam Main Thread");
        }
    }
}
