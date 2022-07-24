package com.exercise_5.view;

import com.exercise_5.domain.House;
import com.exercise_5.service.HouseService;
import com.exercise_5.util.Utility;

/**
 * 1.显示界面
 * 2.接受用户的输入
 * 3.调用HouseService完成对房屋信息的各种操作
 */

public class HouseView {
    private boolean loop = true;//控制显示菜单
    private char key = ' ';//接收用户选择
    HouseService houseService = new HouseService(1);

    //显示主菜单
    public void mainMenu() {
        do {
            System.out.println("---------------房屋出租系统-----------------");
            System.out.println("              1.新 增 房 源");
            System.out.println("              2.查 找 房 源");
            System.out.println("              3.删 除 房 源");
            System.out.println("              4.修 改 房 屋 信 息");
            System.out.println("              5.房 屋 列 表");
            System.out.println("              6.退       出");
            System.out.print("请输入你的选择(1~6): ");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouses();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }

        } while (loop);
    }

    public void listHouses() {
        System.out.println("---------------房 屋 列 表-----------------");
        System.out.println("编号\t\t房主\t\t电话\t\t\t地址\t\t\t月租\t\t\t状态(为出租/已出租)");
        House[] houses = houseService.list();//得到所有的房屋信息
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                continue;
            }
            System.out.println(houses[i]);
        }
        System.out.println("---------------房屋列表显示完毕-----------------");
        System.out.println();
    }

    public void addHouses() {
        System.out.println("-----------------新 增 房 源------------------");
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        System.out.print("电话: ");
        String phone = Utility.readString(11);
        System.out.print("地址: ");
        String address = Utility.readString(20);
        System.out.print("月租: ");
        Double rent = Utility.readDouble();
        System.out.print("状态: ");
        String state = Utility.readString(3);

        //创建一个新的house对象，记录用户输入的信息(id默认为0，后续由程序自动分配)
        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("---------------添加成功！！---------------");
        } else {
            System.out.println("---------------添加失败:)----------------");
        }
    }

    //编写delHouse方法，接收用户输入的id，调用 Service的 del方法
    public void delHouse(){
        System.out.println("----------删 除 房 源----------");
        System.out.print("请输入你要删除的id号(-1取消): ");
        int getId = Utility.readInt();
        if(getId == -1){
            System.out.println("----------你放弃了删除房源----------");
            return;
        }

        System.out.print("你确认删除id为 " + getId + " 的房源吗？");
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y'){
            if(houseService.del(getId)){
                System.out.println("已将id为 " + getId + " 的房源信息删除！！");
            }else {
                System.out.println("\t\t删除失败！！");
                System.out.println("未能找到id为 " + getId + " 的房源信息:)");
            }
        }else{
            System.out.println("----------你放弃了删除房源----------");
        }
    }

    public void exit(){
        System.out.println("你确认要退出吗？？");
        if(Utility.readConfirmSelection() == 'Y'){
            System.out.println("----------已退出！！----------");
            loop = false;
        }
    }

    // 编写find方法，接收用户输入的id，调用Service 的 find方法
    public void findHouse(){
        System.out.println("----------查 找 房 源----------");
        System.out.print("请输入你要查找的id号: ");
        int findId = Utility.readInt();
        House house = houseService.find(findId);
        if(house == null){
            System.out.println("-----未能找到id为 " + findId + " 的房源信息:)-----");
            return;
        }

        System.out.println(house);
    }

    //根据id修改房屋信息
    public void update(){
        System.out.println("----------修 改 房 屋 信 息----------");
        System.out.print("请选择待修改房屋id号(-1表示退出): ");
        int updateId = Utility.readInt();
        if(updateId == -1){
            System.out.println("----------已放弃修改房屋信息----------");
            return;
        }

        //根据id查找房屋信息
        House house = houseService.find(updateId);
        if(house == null){
            System.out.println("-----未能找到id为 " + updateId + " 的房源信息:)-----");
            return;
        }

        System.out.print("姓名(" + house.getName() + "): ");
        String name = Utility.readString(8, house.getName());
        house.setName(name);

        System.out.print("电话(" + house.getPhone() + "): ");
        String phone = Utility.readString(11, house.getPhone());
        house.setPhone(phone);

        System.out.print("地址(" + house.getAddress() + "): ");
        String address = Utility.readString( 20, house.getAddress());
        house.setAddress(address);

        System.out.print("租金(" + house.getRent() + "): ");
        double rent = Utility.readDouble(house.getRent());
        house.setRent(rent);

        System.out.print("状态(" + house.getState() + "): ");
        String state = Utility.readString(3, house.getState());
        house.setState(state);

        System.out.println("----------房屋信息已成功修改----------");
    }
}
