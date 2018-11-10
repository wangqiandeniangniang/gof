package com.example.demo.unit;

/**
 * @InterfaceName IUserSpecification
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 14:25
 * @Version 1.0
 **/
public interface IUserSpecification {
    //候选者是否满足要求
    boolean isSatisfiedBy(User user);
}
