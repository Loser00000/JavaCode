package com.inclass;

/*
    编写老师类：
    (1) 要求有属性"姓名 name" "年龄 age" "职称 post" "基本工资 salary"
    (2) 编写业务方法，introduce(), 实现那输出一个教师的信息
    (3) 编写教师类的三个子类: 教授类，副教授类吗，讲师类。工资级别分别为：
        教授为1.3、副教授为1.2、讲师为1.1。在三个子类里面都重写父类的introduce() 方法
    (4) 定义并初始化一个老师对象，调用业务方法，实现对象基本信息的后台打印
 */

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Lecturer teather = new Lecturer("王月", 42, "高级讲师", 7000, 1.1);
        teather.introduce();
    }
}

class Teather{
    private String name;
    private int age;
    private String post;
    private double salary;
    private double salaryExp;


    public Teather(String name, int age, String post, double salaty, double salaryExp) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salaty;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void introduce(){
        DecimalFormat fom = new DecimalFormat("#0.00");
        System.out.println("姓名: " + getName() +
                "\n年   龄: " + getAge() +
                "\n职   称: " + getPost() +
                "\n工   资: " + fom.format(getSalary() * getSalaryExp()));
    }
}

class Professor extends Teather{
    public Professor(String name, int age, String post, double salary, double salaryExp) {
        super(name, age, post, salary, salaryExp);
    }

    public void introduce(){
        System.out.print("教授");
        super.introduce();
    }
}

class AssProfessor extends Teather{
    public AssProfessor(String name, int age, String post, double salary, double salaryExp) {
        super(name, age, post, salary, salaryExp);
    }

    public void introduce(){
        System.out.print("副教授");
        super.introduce();
    }
}

class Lecturer extends Teather{
    public Lecturer(String name, int age, String post, double salary, double salaryExp) {
        super(name, age, post, salary, salaryExp);
    }

    public void introduce(){
        System.out.print("讲师");
        super.introduce();
    }
}