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

    // and 操作
    IUserSpecification and(IUserSpecification specification);

    // or 操作
    IUserSpecification or(IUserSpecification specification);

    //not操作
    IUserSpecification not();
}
