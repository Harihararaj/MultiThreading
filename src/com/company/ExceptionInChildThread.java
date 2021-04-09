package com.company;
class RunnableThread implements Runnable{
    public void run(){

        for (int i=0;i<5;i++){
//            if(i==2){
//                throw new ArithmeticException("Divide by Zero Exception");
//            }
            System.out.println("child Thread");
        }

    }
}
public class ExceptionInChildThread {
    public static void main(String[] args){
        RunnableThread myThread=new RunnableThread();
        Thread thread=new Thread(myThread);
        thread.setPriority(9);
        thread.start();
        System.out.println(thread.getPriority());
        for (int i=0;i<5;i++){
            System.out.println("Main Thread");
        }
    }
}
