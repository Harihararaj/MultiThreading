package com.company;
class MyThread implements Runnable{
    static Thread mainThreadReference;
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Child Thread");
            try {
                Thread.sleep(2000);//Using Sleep Method
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
public class UsingJoinAndSleepMethods {
    public static void main(String[] args) throws InterruptedException {
	    MyThread.mainThreadReference=Thread.currentThread();
	    MyThread childThreadOfMain=new MyThread();
	    Thread callingThreadChild=new Thread(childThreadOfMain);
	    callingThreadChild.start();
        callingThreadChild.join();// Using Join Method
	    for(int i=0;i<10;i++){
	        System.out.println("Main Thread");
        }
    }
}
