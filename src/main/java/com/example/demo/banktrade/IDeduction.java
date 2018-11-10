package com.example.demo.banktrade;

/**
 * @ClassName IDeduction
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:27
 * @Version 1.0
 **/
public interface IDeduction {
    //扣款，提供交易和卡信息，进行扣款，并返回扣款是否成功
    public boolean exec(Card card, Trade trade);
}
