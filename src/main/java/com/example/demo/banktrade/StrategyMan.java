package com.example.demo.banktrade;

/**
 * @ClassName StrategyMan
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:43
 * @Version 1.0
 **/
public enum  StrategyMan {
    SteadyDeduction("com.example.demo.banktrade.SteadyDeduction"),
    FreeDeduction("com.example.demo.banktrade.FreeDeduction");

    String value = "";

    private StrategyMan(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
