package com.company;

class WaitingThread implements Runnable{
    public void run(){
        NotifyingThread notifyingThread=new NotifyingThread();
        notifyingThread.start();
        synchronized (notifyingThread) {
            try {
                System.out.println("Thread is Waiting for notify");
                notifyingThread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread got notified");
            System.out.println(notifyingThread.total);
        }
    }
}
class NotifyingThread extends Thread{
    int total=0;
    public void run(){
        for(int i=1;i<=100;i++){
            total=total+i;
        }
        synchronized (this) {
            this.notify();
            System.out.println("Iam Notifying");
        }

    }
}
public class InterThreadCommunication {
    public static void main(String[] args){
        WaitingThread waitinThread1=new WaitingThread();
        Thread thread1=new Thread(waitinThread1);
        thread1.start();
    }
}
