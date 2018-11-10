package com.example.demo.unit;

import java.util.ArrayList;

/**
 * @ClassName UserProvider
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 14:13
 * @Version 1.0
 **/
public class UserProvider implements  IUserProvider {
    //用户列表
    private ArrayList<User> userList;

    public UserProvider(ArrayList<User> userList) {
        this.userList = userList;
    }

    //根据指定的规格书查询用户
    @Override
    public ArrayList<User> findUser(IUserSpecification userSpecification) {
        ArrayList<User> result = new ArrayList<>();
        for (User user : userList) {
            if (userSpecification.isSatisfiedBy(user)) {
                result.add(user);
            }
        }
        return result;
    }
}
