package com.example.demo.unit;

import java.util.ArrayList;

/**
 * @InterfaceName IUserProvider
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 13:59
 * @Version 1.0
 **/
public interface IUserProvider {
    //根据条件查询用户
    ArrayList<User> findUser(IUserSpecification userSpecification);

}
