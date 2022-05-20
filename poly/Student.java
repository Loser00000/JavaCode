package com.poly;

public class Student extends Person {
    private double score;

    public Student(String name, int age, double scc) {
        super(name, age);
        this.score = scc;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String say(){
        return super.say() + "\t" + this.score + "分";
    }
}
