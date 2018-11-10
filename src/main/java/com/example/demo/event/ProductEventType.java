package com.example.demo.event;

/**
 * @ClassName ProductEventType
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 10:01
 * @Version 1.0
 **/
public enum  ProductEventType {
    //新建一个产品
    NEW_PRODUCT(1),
    //删除一个产品
    DEL_PRODUCT(2),
    //修改一个产品
    EDIT_PRODUCT(3),
    //克隆一个产品
    CLONE_PRODUCT(4);
    private int value = 0;

    private ProductEventType(int value) {
        this.value = value;
    }

    public int getValue() {
        return  this.value;
    }

}
