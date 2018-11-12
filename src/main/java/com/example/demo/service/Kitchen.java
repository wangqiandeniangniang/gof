package com.example.demo.service;

/**
 * @ClassName Kitchen
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 15:42
 * @Version 1.0
 **/
public class Kitchen implements Cleanable {
    @Override
    public void cleaned() {
        System.out.println("厨房被清理干净");
    }
}
