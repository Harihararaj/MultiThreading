package com.company;
class Runable1 implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Child Thread");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
public class UsingJoinAndSleepMethods {
    public static void main(String[] args) throws InterruptedException {
	    Runable1 childThreadOfMain=new Runable1();
	    Thread callingThreadChild=new Thread(childThreadOfMain);
	    callingThreadChild.start();
        callingThreadChild.join();// Using Join Method
	    for(int i=0;i<10;i++){
	        System.out.println("Main Thread");
        }
    }
}
