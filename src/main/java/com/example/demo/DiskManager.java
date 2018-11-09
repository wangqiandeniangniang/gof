package com.example.demo;

/**
 * @ClassName DiskManager
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:06
 * @Version 1.0
 **/
public class DiskManager {
    //默认的计算大小
    public static String df() {
        return "/df";
    }

    //按照kb来计算
    public static String df_k() {
        return "df_K";
    }

    //按照gb计算
    public static String df_g() {
        return "df_g";
    }
}
