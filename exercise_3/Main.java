package com.exercise_3;

/*
    编写Doctor类{name,age,job,gender,salary}
    相应的getter()和setter()方法，5个参数的构造器，重写父类(Object)的rquals()方法：
    public boolean equals(Object obj)，并判断测试类中创建的两个对象是否相等，相等
    就判断属性是否相同
 */

public class Main {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("sss", 14, "男", 4000);
        Doctor doctor2 = new Doctor("sss", 14, "男", 4000);
        System.out.println(doctor1.equals(doctor2));
    }
}
