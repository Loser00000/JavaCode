package com.inclass;

/*
    通过继承实现员工工资核算打印功能
    父类：员工类
    子类：部门经理类、普通员工类
    (1) 部门经理工资 = 1000 + 单日工资 * 天数 * 等级(1.2)
    (2) 普通员工工资 = 单日工资 * 天数 * 等级(1.0)
    (3) 员工属性：姓名，单日工资，工作天数
    (4) 员工方法(打印工资)
    (5) 普通员工及部门经理都是员工子类，需要重写打印工资方法
    (6) 定义并初始化普通员工对象，调用打印工资方法输入工资，
        定义并初始化部门经理对象，调用打印工资方法输入工资
 */

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("王总", 140, 30, 1.2);
        manager.setBonus(1000);
        NormalStaff normalStaff = new NormalStaff("小刘", 80, 30, 1.0);
        manager.printSalary();
        normalStaff.printSalary();
    }
}

class Staff{
    private String name;
    private double dailySalary;
    private int workDays;
    private double salaryExp;

    public Staff(String name, double dailySalary, int workDays, double salaryExp) {
        this.name = name;
        this.dailySalary = dailySalary;
        this.workDays = workDays;
        this.salaryExp = salaryExp;
    }

    public double getSalaryExp() {
        return salaryExp;
    }

    public void setSalaryExp(double salaryExp) {
        this.salaryExp = salaryExp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(double dailySalary) {
        this.dailySalary = dailySalary;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public void printSalary() {
        DecimalFormat defor = new DecimalFormat("#0.00");
        double sum = dailySalary * workDays * salaryExp;
        System.out.println("员工的工资:" +
                defor.format(sum));
    }
}

class Manager extends Staff {
    private double bonus;

    public Manager(String name, double dailySalary, int workDays, double salaryExp) {
        super(name, dailySalary, workDays, salaryExp);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSalary() {
        DecimalFormat defor = new DecimalFormat("#0.00");
        double sum = getDailySalary() * getWorkDays() * getSalaryExp() + bonus;
        System.out.println("经理的工资:" + defor.format(sum));
    }
}

class NormalStaff extends Staff {

    public NormalStaff(String name, double dailySalary, int workDays, double salaryExp) {
        super(name, dailySalary, workDays, salaryExp);
    }

    @Override
    public void printSalary() {
        super.printSalary();
    }
}