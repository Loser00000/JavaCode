package com.poly;

public class PloyArray {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("小明", 15);
        persons[1] = new Student("小王", 19, 82);
        persons[2] = new Student("东东", 20, 95);
        persons[3] = new Teacher("敏老师", 45, 5500);
        persons[4] = new Teacher("张老师", 32, 4100);

        for(int i = 0; i < persons.length; i++){
            System.out.println(persons[i].say());
        }
    }
}
