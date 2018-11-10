package com.example.demo.event;

import java.util.Observable;

/**
 * @ClassName ProductEvent
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 10:03
 * @Version 1.0
 **/
public class ProductEvent extends Observable {
    //事件起源
    private Product source;
    //事件的类型
    private ProductEventType type;

    //传入事件的源头，默认为新建类型
    public ProductEvent(Product product) {
        this(product, ProductEventType.NEW_PRODUCT);
    }

    //事件源头以及事件类型
    public ProductEvent(Product product, ProductEventType type) {
        this.source = product;
        this.type = type;
        //事件触发
        notifyEventDispatch();
    }
    //获取事件的始作俑者
    public Product getSource() {
        return source;
    }

    public ProductEventType getType() {
        return type;
    }

    private void notifyEventDispatch() {
        super.addObserver(EventDispatch.getEventDispatch());
        super.setChanged();
        super.notifyObservers(source);
    }
}
