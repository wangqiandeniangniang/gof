package com.example.demo.unit;

/**
 * @ClassName AddSpecification
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 14:56
 * @Version 1.0
 **/
public class AddSpecification extends CompositeSpecification {
    //传递两个规格书进行and操作
    private IUserSpecification left;
    private IUserSpecification right;
    public AddSpecification(IUserSpecification left, IUserSpecification right) {
        this.left = left;
        this.right = right;
    }

    //进行and运算
    @Override
    public boolean isSatisfiedBy(User user) {
        return left.isSatisfiedBy(user) && right.isSatisfiedBy(user);
    }
}
