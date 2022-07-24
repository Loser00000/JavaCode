package com.exercise_5.service;

import com.exercise_5.domain.House;

/**
 * HouseService [业务层]
 * 定义House[],保存House对象
 * 1.响应HouseView的调用
 * 2.完成对房屋信息的所有操作(增删改查)
 */

public class HouseService {

    private House[] houses;//用于存放House对象
    private int housesNum = 0;//用于记录房间信息个数
    private int idCounter = 1;//用于记录id

    public HouseService(int size) {
        houses = new House[size];
        //测试：
        houses[0] = new House(1,"xxx", "111222", "iiiii", 5000, "未出租");

    }

    //list方法：返回所有的houses信息
    public House[] list(){
        return houses;
    }

    //add方法：添加新对象,并给新对象赋id，返回boolean
    public boolean add(House newHouse){
        //判断是否还可以继续添加
        if(housesNum == houses.length){
            //不能，就扩容
            House[] addHouses = new House[housesNum+1];
            for (int i = 0; i < houses.length; i++) {
                addHouses[i] = houses[i];
            }
            houses = addHouses;
        }

        houses[housesNum++] = newHouse;
        //给新增对象赋id
        newHouse.setId(idCounter++);

        return true;
    }

    //编写del类，接收HouseView的id号，删除对应的房源
    public boolean del(int delId){
        //利用二分法或遍历法查找对应id的房源
        //这里使用二分法
        int low = 0;
        int high = houses.length - 1;
        int index = -1;
        while(low <= high) {
            int mid = (low + high) / 2;

            if(delId == houses[mid].getId()){
                //找到目标
                index = mid;
                break;
            }
            if(delId > houses[mid].getId()){
                low = mid + 1;
            }
            if(delId < houses[mid].getId()){
                high = mid - 1;
            }
        }

        if(index == -1){//说明在这组数组中没有这个id
            return false;
        }

        //删除对应的房源信息
        for (int i = index; i < housesNum -1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--housesNum] = null;//把最后一个数组元素制空，并减去一个housesNum
        return true;
    }

    //编写find类，接收HouseView的id号，查找并返回对应的的房屋对象，没有就返回null
    public House find(int findId){
        //利用二分法或遍历法查找对应id的房源
        //这里使用二分法
        int low = 0;
        int high = houses.length - 1;
        int index = -1;
        while(low <= high) {
            int mid = (low + high) / 2;

            if(findId == houses[mid].getId()){
                //找到目标
                index = mid;
                break;
            }
            if(findId > houses[mid].getId()){
                low = mid + 1;
            }
            if(findId < houses[mid].getId()){
                high = mid - 1;
            }
        }

        if(index == -1){//说明在这组数组中没有这个id
            return null;
        }

        return houses[index];
    }
}
