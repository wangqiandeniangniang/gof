package com.example.demo.banktrade;

/**
 * @ClassName Card
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:24
 * @Version 1.0
 **/
public class Card {
    //IC卡号码
    private String cardNo = "";

    //卡内的固定交易金额
    private int steadyMoney = 0;

    //卡内自由交易金额
    private int freeMoney = 0;

    public int getSteadyMoney() {
        return steadyMoney;
    }

    public void setSteadyMoney(int steadyMoney) {
        this.steadyMoney = steadyMoney;
    }

    public int getFreeMoney() {
        return freeMoney;
    }

    public void setFreeMoney(int freeMoney) {
        this.freeMoney = freeMoney;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
