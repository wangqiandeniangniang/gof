package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Client
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 11:23
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        Invoker invoker = new Invoker();
        while (true) {
            //Unix下的默认值提示符号
            System.out.println("#");
            //捕捉输出
            String input = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            //输入quit或exit 则退出
            if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
                return;
            }
            System.out.println(invoker.exec(input));
        }
    }
}
