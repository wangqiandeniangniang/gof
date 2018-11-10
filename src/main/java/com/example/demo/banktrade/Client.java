package com.example.demo.banktrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Client
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:53
 * @Version 1.0
 **/
public class Client {


    public static void main(String[] args) {
        //初始化一张IC卡
        Card card = initIC();
        //显示一下卡内的信息
        System.out.println("==============初始卡信息：===========");
        showCard(card);
        //是否停止运行标志
        boolean flag = true;
        while (flag) {
            Trade trade = createTrade();
            DeductionFacde.deduct(card, trade);
            //交易成功，打印出成功处理的消息
            System.out.println("\n==============交易凭证============");
            System.out.println(trade.getTradeNo() + "交易成功");
            System.out.println("本次发生的交易金额为：" + trade.getAmount() / 100.0 + "元");
            //展示一下卡内信息
            showCard(card);
            System.out.println("\n是否需要退出？ （Y/N）");
            if (getInput().equalsIgnoreCase("y")) {
                flag = false; //退出
            }
        }
    }

    private static Trade createTrade() {

        Trade trade = new Trade();
        System.out.println("请输入交易编码：");
        trade.setTradeNo(getInput());
        System.out.println("请输入交易金额：");
        trade.setAmount(Integer.parseInt(getInput()));
        return  trade;
    }

    //打印出当前卡内交易余额
    private static void showCard(Card card) {
        System.out.println("IC卡编号：" + card.getCardNo());
        System.out.println("固定类型余额：" + card.getSteadyMoney() / 100.00 + "天");
        System.out.println("自由类型余额：" + card.getFreeMoney() / 100.00 + "天");
    }

    //初始化一个IC卡
    private static Card initIC() {
        Card card = new Card();
        card.setCardNo("1111111111111111102");
        card.setFreeMoney(100000); // 1000元
        card.setSteadyMoney(80000); // 800元
        return card;

    }

    //获取键盘输入
    public static String getInput() {
        String str = "";
        try {
            str = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
