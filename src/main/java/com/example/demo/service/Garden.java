package com.example.demo.service;

/**
 * @ClassName Garden
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 15:42
 * @Version 1.0
 **/
public class Garden implements Cleanable {
    @Override
    public void cleaned() {
        System.out.println("花园被清洁干净");
    }
}
