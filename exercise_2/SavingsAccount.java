package com.exercise_2;

/*
    拓展父类，使每个月都有利息产生(earnMonthlyInterest)，并且每个月有三次免手续费的存款和取款
 */

public class SavingsAccount extends BankAccount {
    private int doFree = 3;
    private double rate = 0.01;//利率

    public SavingsAccount(double balance) {
        super(balance);
    }

    public int getDoFree() {
        return doFree;
    }

    public void setDoFree(int doFree) {
        this.doFree = doFree;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void deposit(double amount) {//存款
        //判断是否可以免手续
        if(doFree > 0){
            super.deposit(amount);
            doFree--;
        }else{
            super.deposit(amount - 1);
        }
    }

    @Override
    public void withdraw(double amount) {//取款
        //判断是否可以免手续
        if(doFree > 0){
            super.withdraw(amount);
            doFree--;
        }else{
            super.withdraw(amount + 1);
        }
    }

    public void earnMonthlyInterest(){
        doFree = 3;
        super.deposit(getBalance() * rate);
    }
}
