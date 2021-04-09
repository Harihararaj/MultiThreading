package com.company;
class Account{
    String name;
    int balance;
    Account(String name,int balance){
        this.name=name;
        this.balance=balance;
    }

    public synchronized void withdraw(int amountToBeDebited){
        if(amountToBeDebited>this.balance){
            try {
                throw new BalanceIsLessThanAmountToBeDebited("Please Enter the Valid Amount to be Debited");
            }catch (BalanceIsLessThanAmountToBeDebited e){
                System.out.println(e);
            }
        }
        else{
            this.balance=this.balance-amountToBeDebited;
        }
    }
    public void balanceCheck(){
        System.out.println("Card Holder Name is: "+this.name);
        System.out.println("The Balance in the Account is :"+this.balance);
    }
}
class BalanceIsLessThanAmountToBeDebited extends RuntimeException{
    BalanceIsLessThanAmountToBeDebited(String description){
        super(description);
    }
}
class Thread1 implements Runnable{
    Account account;
    int ammount;
    Thread1(Account account,int ammount){
        this.account=account;
        this.ammount=ammount;
    }
    public void run(){
        account.withdraw(ammount);
        account.balanceCheck();
    }
}
public class SynchronizingAnObject {
    public static void main(String[] args){
        Account account1=new Account("hari",10000);
        Account account2=new Account("naveen",10000);
        Account account3=new Account("dhina",10000);
        Thread1 runnable=new Thread1(account1,5000);
        Thread1 runnable1=new Thread1(account1,8000);
        Thread1 runnable2=new Thread1(account2,2000);
        account1.balanceCheck();
        account2.balanceCheck();
        account3.balanceCheck();
        System.out.println("--------------------------------------------------------------");
        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable1);
        Thread thread3=new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
