package com.smallchangeApp.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是实现零钱通的各个功能的类
 * 使用OOP(面向对象编程)
 * 将各个功能对应一个方法
 */
public class Oop {

    //定义相关的变量
    boolean loop = true;
    Scanner mySc = new Scanner(System.in);
    String inPut = "";

    //2. 完成零钱通明细
    //思路：(1) 可以把收益入账和消费，保存到数组中
    //     (2) 可以使用对象
    //     (3) 简单的话可以使用String拼接
    String details = "------------------- 零钱通明细 -------------------";

    //3. 完成收益入账
    //思路：定义新的变量
    double money = 0;
    double balance = 0;
    Date date = null; //date 是 java.util.Date 类型，表示日期
    //用于日期格式化的
    SimpleDateFormat setDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //4. 消费
    //思路：(1) 定义新变量，记录消费的原因
    String note = "";

    //5. 改进：退出的二次确认
    //思路：
    // (1) 利用循环，反复向用户提出是否退出，用户只能输入y/n，
    //     输入其他的就循环输入指令，直到输入y/n


    //先完成显示菜单，并可以选择
    public void mainMenu(){
        do{
            System.out.println("\n========== 菜单 ==========");
            System.out.println("\t\t1 零钱通明细");
            System.out.println("\t\t2 收益入账");
            System.out.println("\t\t3 消    费");
            System.out.println("\t\t4 推    出");

            System.out.print("请选择(1~4):");
            inPut = mySc.next();

            //使用 switch 分支控制
            switch(inPut){
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.inCome();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择！");
                    break;
            }

        }while(loop);
    }

    //完成零钱通明细
    public void detail(){
        System.out.println(details);
    }

    //完成收益入账
    public boolean inCome(){
        System.out.print("收益入账金额：");
        money = mySc.nextDouble();
        //money 的消费范围应该校验
        //思路：判断是否有不合理的条件，有则return，没有就继续执行下面的代码
        if(money <= 0){
            System.out.println("收益的金额应大于0");
            return false;
        }

        balance += money;
        //拼接收益入账信息到 details
        date = new Date();//获取当前的日期
        details += "\n收益入账\t+" + money + "\t\t" +
                setDate.format(date) + "\t\t" + balance;
        return true;
    }

    //消费
    public boolean pay(){
        System.out.println("消费金额：");
        money = mySc.nextDouble();
        //money 的消费范围应该校验
        //思路：判断是否有不合理的条件，有则break，没有就继续执行下面的代码
        if(money <= 0){
            System.out.println("收益的金额应大于0");
            return false;
        }

        if(balance - money < 0){
            System.out.println("你的余额不足以支付该消费！");
            System.out.println("你的余额还有：" + balance);
            return false;
        }

        System.out.println("消费内容：");
        note = mySc.next();
        balance -= money;
        date = new Date();//获取当前时间
        details += "\n" + note + "\t\t-" + money + "\t\t" +
                setDate.format(date) + "\t\t" + balance;
        return true;
    }

    //退出
    public void exit(){
        // (1) 利用循环，反复向用户提出是否退出，用户只能输入y/n，
        //     输入其他的就循环输入指令，直到输入y/n
        // 思路：
        // (1) 定义变量choice 接收用户的选择
        // (2) 使用while循环 + break，来处理接收的是y还是n

        String choice = "";
        while(true){
            System.out.println("你确定退出嘛？y/n");
            choice = mySc.next();
            if("y".equals(choice) || "n".equals(choice)){
                break;
            }
        }
        if("y".equals(choice)){
            loop = false;
        }
    }
}
