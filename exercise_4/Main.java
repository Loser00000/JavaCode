package com.exercise_4;

/*
    体会多态的用法：
    编写一个程序，实现主人给动物喂食物的信息
    例如：***(人名)给***(某某动物)喂***(某种食物)
 */

import com.exercise_4.animal.Cat;
import com.exercise_4.animal.Dog;
import com.exercise_4.food.Bone;
import com.exercise_4.food.Fish;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("小明", '男', 21);
        Dog dog = new Dog("狗", 2, '雄');
        Cat cat = new Cat("猫", 2, '母');

        Fish fish = new Fish();
        Bone bone = new Bone();

        person.feed(dog, bone);
        person.feed(fish, cat);
    }
}
