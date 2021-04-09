package com.company;
class A{
    public synchronized void m1(B b){
        System.out.println("Iam m1 with lock of a");
        try {
            System.out.println("Iam Sleeping Now");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Iam calling last method in b object");
        b.last();
    }
    public synchronized void last(){
        System.out.println("Iam last method called by a object");
    }
}
class B{
    public synchronized void m1(A a){
        System.out.println("Iam m1 with lock of b");
        try {
            System.out.println("Iam Sleeping Now");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Iam calling last method in a object");
        a.last();
    }
    public synchronized void last(){
        System.out.println("Iam last method called by b object");
    }
}
class Threadd1 extends Thread{
    A a;
    B b;
    Threadd1(A a,B b){
        this.a=a;
        this.b=b;
    }
    public void run(){
        a.m1(b);
    }
}
class Threadd2 extends Thread{
    B b;
    A a;
    Threadd2(B b,A a){
        this.b=b;
        this.a=a;
    }
    public void run(){
        b.m1(a);
    }
}
public class Deadlock {
    public static void main(String[] args){
        A a = new A();
        B b=new B();
        Threadd1 thread1=new Threadd1(a,b);
        Threadd2 thread2=new Threadd2(b,a);
        thread1.start();
        thread2.start();
    }
}
