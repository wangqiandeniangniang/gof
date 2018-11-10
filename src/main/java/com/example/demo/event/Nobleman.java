package com.example.demo.event;

/**
 * @ClassName Nobleman
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 10:33
 * @Version 1.0
 **/
public class Nobleman extends EventCustomer {

    //定义贵族能够处理的事件级别
    public Nobleman() {
        super(EventCustomerType.EDIT);
        super.addCustomerType(EventCustomerType.CLONE);
    }
    @Override
    public void exec(ProductEvent event) {

        //事件的源头
        Product source = event.getSource();
        //事件类型
        ProductEventType type = event.getType();
        if (type.getValue() == EventCustomerType.CLONE.getValue()) {
            System.out.println("贵族处理事件：" + source.getName() + "克隆， 事件类型= " + type);
        } else {
            System.out.println("贵族处理事件：" + source.getName() + "修改， 事件类型= " + type);
        }
    }
}
