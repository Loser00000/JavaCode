package com.exercise_2;

public class Main {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(1000);
//        checkingAccount.deposit(20);//1019
//        checkingAccount.withdraw(10);
//        System.out.println(checkingAccount.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance());//1300
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance());//1399

        //月初，定时器自动调一下
        savingsAccount.earnMonthlyInterest();
        System.out.println(savingsAccount.getBalance());//1399 + 13.99 = 1412.99
        savingsAccount.withdraw(100);
        System.out.println(savingsAccount.getBalance());//1312.99
        savingsAccount.withdraw(100);
        savingsAccount.withdraw(100);
        System.out.println(savingsAccount.getBalance());//1112.99
        savingsAccount.withdraw(100);
        System.out.println(savingsAccount.getBalance());//1011.99
    }
}
