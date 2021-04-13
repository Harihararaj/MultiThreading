package com.company;
class ShutdownHookThread extends Thread{
    public void run(){
        System.out.println("Program terminates");
    }
}
public class ShutDownHook {
    public static void main(String[] args){
        ShutdownHookThread shutdownHook=new ShutdownHookThread();
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        System.out.println("Program is going to be closed");
        System.out.println("Program is going to be closed");
        System.out.println("Program is going to be closed");
        System.exit(0);
        System.out.println("Program is going to be closed");
        System.out.println("Program is going to be closed");
        //System.out.println(10/0);

        try {
            Thread.sleep(2000);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }
}
