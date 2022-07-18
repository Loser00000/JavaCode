package com.exercise_4;

import com.exercise_4.animal.Animal;
import com.exercise_4.food.Food;

public class Person {
    private String name;
    private char gender;
    private int age;

    public Person(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void feed(Animal animal, Food food){
        System.out.println(name + "给" + animal.getName() +
                "喂" + food.getName());
    }

    public void feed(Food food, Animal animal){
        System.out.println(name + "给" + animal.getName() +
                "喂" + food.getName());
    }
}
