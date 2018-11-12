package com.example.demo.service;

/**
 * @ClassName Cloth
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 15:45
 * @Version 1.0
 **/
public class Cloth implements Cleanable {
    @Override
    public void cleaned() {
        System.out.println("衣服被清洁干净了");
    }
}
