package com.example.demo.jdk8;

/**
 * @InterfaceName Formula
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/12/3 12:04
 * @Version 1.0
 **/
public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        formula.calculate(100); // 100.00
        formula.sqrt(16);
        Formula formula1 = (a)-> a+1;
        System.out.println(formula1.sqrt(2));
    }
}
