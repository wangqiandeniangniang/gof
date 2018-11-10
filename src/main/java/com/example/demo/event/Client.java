package com.example.demo.event;

/**
 * @ClassName Client
 * @Description
 * 1、EventDispacth  这个事件分发器
2、在ProductManager创建对象时触发事件ProductEvent
3、然后触发EventDispacth,
4、这个EventDispacth会注册一些事件
 * @Author chen.liang
 * @Date 2018/11/10 10:43
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        //获取事件分发中心
        EventDispatch eventDispatch = EventDispatch.getEventDispatch();
        //接受乞丐对事件的处理
        eventDispatch.registerCustomer(new Beggar());
        //接受平民对象事件的处理
        eventDispatch.registerCustomer(new Commoner());
        //接受贵族对事件处理
        eventDispatch.registerCustomer(new Nobleman());
        //建立一个原子弹生成工厂
        ProductManager productManager = new ProductManager();
        //制造一个产品
        System.out.println("=============模拟创建产品事件==========");
        System.out.println("创建一个叫做小孩子的原子弹");
        Product product = productManager.createProduct("小孩子原子弹");
        //修改一个产品
        System.out.println("\n=======模拟修改产品事件============");
        System.out.println("把小男孩原子弹修改为胖子号原子弹");
        productManager.editProduct(product, "棒子好原子弹");
        //再克隆一个原子弹
        System.out.println("\n===========模拟克隆产品事件===========");
        System.out.println("克隆胖子原子弹");
        productManager.clone(product);
        //遗弃一个产品
        System.out.println("\n============模拟销毁产品事件===========");
        System.out.println("遗弃棒子好与原子弹");
        productManager.abandonProduct(product);

    }
}
