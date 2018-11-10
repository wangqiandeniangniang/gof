package com.example.demo.banktrade;

/**
 * @ClassName StratetegyFactory
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:46
 * @Version 1.0
 **/
public class StratetegyFactory {
    //策略工厂

    public static IDeduction getDeduction(StrategyMan strategyMan) {
        IDeduction deduction = null;
        try {
            deduction = (IDeduction) Class.forName(strategyMan.getValue()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deduction;
    }
}
