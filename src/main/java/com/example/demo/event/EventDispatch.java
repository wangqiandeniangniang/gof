package com.example.demo.event;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * @ClassName EventDispatch
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 10:08
 * @Version 1.0
 **/
public class EventDispatch implements Observer {
    //单例模式
    private final static EventDispatch dispatch = new EventDispatch();
    //事件消费者
    private Vector<EventCustomer> customer = new Vector<>();
    //不允许生成新的实例
    private EventDispatch() {

    }
    //获取单例对象
    public static EventDispatch getEventDispatch() {
        return dispatch;
    }
    //事件触发
    @Override
    public void update(Observable o, Object arg) {
        //事件源头
        Product product = (Product) arg;
        //事件
        ProductEvent event = (ProductEvent)o;
        //处理者处理， 这里是中介模式的核心，可以是很复杂的业务逻辑
        for (EventCustomer e : customer) {
            //处理能力是否匹配
            for (EventCustomerType type : e.getCustomerType()) {
                if (type.getValue() == event.getType().getValue()) {
                    e.exec(event);
                }
            }
        }
    }

    //注册事件处理者
    public void registerCustomer(EventCustomer customer) {
        this.customer.add(customer);
    }
}
