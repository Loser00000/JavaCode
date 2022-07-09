package com.exercise;

/*
    5.设计父类—员工类。子类:工人类(Worker),农民类(Peasant),教师类(Teacher),科学家类(Scientist),
      服务生类(Waiter)。
     (1)其中工人,农民,服务生只有基本工资
     (2)教师除基本工资外,还有课酬(元/天)
     (3)科学家除基本工资外,还有年终奖
     (4)编写一个测试类,将各种类型的员工的全年工资打印出来

 */

public class Exercise_17 {
    public static void main(String[] args) {
        Worker worker = new Worker("小明", 2300, "男", 21);
        Peasant peasant = new Peasant("小强", 2000, "女", 21);
        Teacher teacher = new Teacher("小Q", 3100, "女", 21, 1000, 3);
        Scientist scientist = new Scientist("小T", 8000, "男", 21, 12000);
        Waiter waiter = new Waiter("小E", 2500, "男", 21);

        worker.print();
        System.out.println();
        peasant.print();
        System.out.println();
        teacher.print();
        System.out.println();
        scientist.print();
        System.out.println();
        waiter.print();
    }
}

class Employee {
    public int month = 12;

    private String name;
    private double baseSalary;
    private String gender;
    private int age;

    public Employee(String name, double baseSalary, String gender, int age) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.gender = gender;
        this.age = age;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void print() {
        System.out.println("姓名: " + name +
                "\n性别: " + gender +
                "\n年龄: " + age +
                "\n全年工资: " + (baseSalary * month));
    }
}

class Worker extends Employee {
    public Worker(String name, double baseSalary, String gender, int age) {
        super(name, baseSalary, gender, age);
    }

    @Override
    public void print(){
        System.out.println("工人");
        super.print();
    }
}

class Peasant extends Employee {
    public Peasant(String name, double baseSalary, String gender, int age) {
        super(name, baseSalary, gender, age);
    }

    @Override
    public void print(){
        System.out.println("农民");
        super.print();
    }
}

class Teacher extends Employee {
    private double classSalary = 0;
    private double classDay = 0;

    public Teacher(String name, double baseSalary, String gender, int age,
                   double classSalary, double classDay) {
        super(name, baseSalary, gender, age);
        this.classSalary = classSalary;
        this.classDay = classDay;
    }

    public double getClassSalary() {
        return classSalary;
    }

    public void setClassSalary(double classSalary) {
        this.classSalary = classSalary;
    }

    public double getClassDay() {
        return classDay;
    }

    public void setClassDay(double classDay) {
        this.classDay = classDay;
    }

    @Override
    public void print(){
        System.out.println("教师");
        System.out.println("姓名: " + getName() +
                "\n性别: " + getGender() +
                "\n年龄: " + getAge() +
                "\n全年工资: " + (getBaseSalary() * month + classSalary * classDay));
    }
}

class Scientist extends Employee {
    private double bonus;

    public Scientist(String name, double baseSalary, String gender, int age, double bonus) {
        super(name, baseSalary, gender, age);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void print(){
        System.out.println("科学家");
        System.out.println("姓名: " + getName() +
                "\n性别: " + getGender() +
                "\n年龄: " + getAge() +
                "\n全年工资: " + (getBaseSalary() * month + bonus));
    }
}

class Waiter extends Employee {
    public Waiter(String name, double baseSalary, String gender, int age) {
        super(name, baseSalary, gender, age);
    }

    @Override
    public void print(){
        System.out.println("服务员");
        super.print();
    }
}