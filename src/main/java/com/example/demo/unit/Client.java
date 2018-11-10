package com.example.demo.unit;

import java.util.ArrayList;

/**
 * @ClassName Client
 * @Description 规格模式， 将改变内容扩展
 * @Author chen.liang
 * @Date 2018/11/10 14:17
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        //首先初始化一批用户
        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(new User("张三", 30));
        userArrayList.add(new User("李四", 20));
        userArrayList.add(new User("王五", 10));
        IUserSpecification userSpecification = new UserByAgeThan(20);
        //定义一个用户查询类
        UserProvider userProvider = new UserProvider(userArrayList);
        //打印出年龄大于20岁的用户
        System.out.println("=====年龄大于20岁的用户===");
        for (User u : userProvider.findUser(userSpecification)) {
            System.out.println(u);
        }
    }
}
