package com.example.demo.event;

/**
 * @ClassName Beggar
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 10:28
 * @Version 1.0
 **/
public class Beggar extends EventCustomer {
    //只能处理被人遗弃的东西
    public Beggar() {
        super(EventCustomerType.DEL);
    }
    @Override
    public void exec(ProductEvent event) {
        //事件的源头
        Product source = event.getSource();
        //事件类型
        ProductEventType type = event.getType();
        System.out.println("乞丐处理事件：" + source.getName() + "销毁，对象类型= " + type);

    }
}
