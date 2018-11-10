package com.example.demo.unit;

/**
 * @ClassName UserByAgeThan
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 14:30
 * @Version 1.0
 **/
public class UserByAgeThan extends CompositeSpecification{
    //基准年龄
    private int age;

    //构造函数传递基准年龄
    public UserByAgeThan(int age) {
        this.age = age;
    }
    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getAge() > age;
    }
}
