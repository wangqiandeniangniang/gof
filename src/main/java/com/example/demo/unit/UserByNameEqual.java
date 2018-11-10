package com.example.demo.unit;

/**
 * @ClassName UserByNameEqual
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 14:28
 * @Version 1.0
 **/
public class UserByNameEqual implements IUserSpecification {

    //基准名称
    private String name;
    //构造函数传递基准名称
    public UserByNameEqual(String name) {
        this.name = name;
    }
    @Override
    public boolean isSatisfiedBy(User user) {

        return user.getName().equals(name);
    }
}
