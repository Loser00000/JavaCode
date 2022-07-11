package com.exercise_2;

/*
    拓展父类，对每次存款和取款都收取1元的手续费
 */

public class CheckingAccount extends BankAccount {

    public CheckingAccount(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {//存款
        super.deposit(amount - 1);
        //1元转入银行的账户里
    }

    @Override
    public void withdraw(double amount) {//取款
        super.withdraw(amount + 1);
        //1元转入银行的账户里
    }
}
