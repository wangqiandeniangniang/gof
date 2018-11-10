package com.example.demo.unit;

/**
 * @ClassName User
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 13:58
 * @Version 1.0
 **/
public class User {
    //姓名
    private String name ;

    //年龄
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
