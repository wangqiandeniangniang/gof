package com.example.demo.unit;

/**
 * @ClassName OrSpecification
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 14:57
 * @Version 1.0
 **/
public class OrSpecification extends CompositeSpecification {

    //左右规格书
    private IUserSpecification left;
    private IUserSpecification right;
    public OrSpecification(IUserSpecification left, IUserSpecification right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return left.isSatisfiedBy(user) || right.isSatisfiedBy(user);
    }
}
