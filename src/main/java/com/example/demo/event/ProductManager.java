package com.example.demo.event;

/**
 * @ClassName ProductManager
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 9:42
 * @Version 1.0
 **/
public class ProductManager {
    //是否可以创建一个产品
    private boolean isPermittedCreate = false;

    //建立一个产品
    public Product createProduct(String name) {
        //首先修改权限，允许创建
        isPermittedCreate = true;
        Product product = new Product(this, name);
        //产生一个创建事件
        new ProductEvent(product, ProductEventType.NEW_PRODUCT);
        return  product;
    }

    //废弃一个产品
    public void abandonProduct(Product product) {
        //销毁一个产品， 例如删除数据库记录
        //产生删除事件
        new ProductEvent(product, ProductEventType.DEL_PRODUCT);
        product = null;
    }

    //修改一个产品
    public void editProduct(Product p, String name) {
        //修改后的产品
        p.setName(name);
        new ProductEvent(p, ProductEventType.EDIT_PRODUCT);
    }

    public boolean isCreateProduct() {
        return isPermittedCreate;
    }

    //克隆一个产品
    public Product clone(Product product) {
        //产生一个克隆事件
        new ProductEvent(product, ProductEventType.CLONE_PRODUCT);
        return  product.clone();
    }
}
