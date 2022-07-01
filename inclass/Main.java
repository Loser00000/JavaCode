package com.inclass;

/*
    定义一个Person类{name. age. job}.初始化Person对象数组。
    有3个person对象。并按照age从大到小进行排序，提示：使用冒泡排序
 */

public class Main {
    public static void main(String[] args) {
        Person[] person = {new Person("jjj", 17, "w"),
                new Person("kkk", 15, "jkkj"),
                new Person("jklj", 44, "jkjkjk")};

        for (int i = 0; i < person.length - 1; i++) {
            Boolean flag = true;
            for (int j = 0; j < person.length - 1 - i; j++) {
                if(person[j].getAge() < person[j + 1].getAge()) {
                    Person temp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = temp;
                    flag = false;
                }
            }
            if(flag == true){
                break;
            }
        }

        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].info());
        }

        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].toString());
        }
    }
}

class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String info(){
        return getName() + "\t" +  getAge() + "\t" + getJob();
    }
}