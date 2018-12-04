package com.example.demo.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Lambda
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/12/3 12:06
 * @Version 1.0
 *
 *  Lambda的范围：
 *  1、它可以访问外部区域的局部变量，以及成员变量和静态变量
 *  2、
 **/
public class Lambda {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        // 方式一
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        //方式二
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        //方式三
        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        //方式四
        Collections.sort(names, (a, b) -> b.compareTo(a));
    }
}
