package com.example.demo.event;

/**
 * @ClassName Commoner
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 10:31
 * @Version 1.0
 **/
public class Commoner extends EventCustomer {
    //定义平民能够处理的事件的级别
    public Commoner() {
        super(EventCustomerType.NEW);
    }
    @Override
    public void exec(ProductEvent event) {
        //事件的源头
        Product source = event.getSource();
        //事件类型
        ProductEventType type = event.getType();
        System.out.println("平民处理事件： " + source.getName() + "诞生记，事件类型= " + type);
    }
}
