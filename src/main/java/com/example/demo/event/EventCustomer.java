package com.example.demo.event;

import java.util.Vector;

/**
 * @ClassName EventCustomer
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 10:21
 * @Version 1.0
 **/
public abstract class EventCustomer {
    //容纳每个消费者能够处理的级别
    private Vector<EventCustomerType> customerType = new Vector<EventCustomerType>();

    //每个消费者都要声明自己处理哪一类的事件
    public EventCustomer(EventCustomerType type) {
        addCustomerType(type);
    }

    //每个消费者可以消费多个事件
    public void addCustomerType(EventCustomerType type) {
        customerType.add(type);
    }

    //得到自己处理能力

    public Vector<EventCustomerType> getCustomerType() {
        return customerType;
    }

    //每个事件都要对事件进行声明试消费
    public abstract void exec(ProductEvent event);
}
