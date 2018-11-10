package com.example.demo.unit;

/**
 * @ClassName NotSpecification
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 14:56
 * @Version 1.0
 **/
public class NotSpecification extends CompositeSpecification {
    private IUserSpecification specification;

    public NotSpecification(IUserSpecification specification) {
        this.specification = specification;
    }


    @Override
    public boolean isSatisfiedBy(User user) {
        return !specification.isSatisfiedBy(user);
    }
}
