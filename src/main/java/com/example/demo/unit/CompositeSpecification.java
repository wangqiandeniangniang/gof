package com.example.demo.unit;

/**
 * @ClassName CompositeSpecification
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 14:52
 * @Version 1.0
 **/
public abstract class CompositeSpecification implements  IUserSpecification{
    //是否满足要求条件有实现类实现
   public abstract boolean isSatisfiedBy(User user);

   //and 操作

    @Override
    public IUserSpecification and(IUserSpecification specification) {
        return new AddSpecification(this, specification);
    }

    //not 操作
    @Override
    public IUserSpecification not() {
        return new NotSpecification(this);
    }

    //or操作

    @Override
    public IUserSpecification or(IUserSpecification specification) {
        return new OrSpecification(this, specification);
    }
}
