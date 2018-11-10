package com.example.demo.event;

import com.example.demo.banktrade.StratetegyFactory;

/**
 * @ClassName Product
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 9:32
 * @Version 1.0
 **/
public class Product implements Cloneable {
    //产品名称
    private String name;
    //是否可以属性变更
    private boolean canChanged = false;

    //产生一个新的产品
    public Product(ProductManager manager, String name) {
        //允许建立
        if (manager.isCreateProduct()) {
            canChanged = true;
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (canChanged) {
            this.name = name;
        }

    }
    //复写clone方法
    @Override
    public Product clone() {
        Product p = null;
        try {
            p = (Product)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
