package com.example.demo.banktrade;

/**
 * @ClassName Trade
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:26
 * @Version 1.0
 **/
public class Trade {
    //交易编号
    private String tradeNo = "";
    //交易金额
    private int amount = 0;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
