package com.example.demo.banktrade;

/**
 * @ClassName DeductionContext
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:37
 * @Version 1.0
 **/
public class DeductionContext {
    //扣款策略
    private IDeduction deduction = null;

    //构造函数传递策略
    public DeductionContext(IDeduction deduction) {
        this.deduction = deduction;
    }

    //执行扣款
    public boolean exec(Card card, Trade trade) {
        return this.deduction.exec(card, trade);
    }
}
