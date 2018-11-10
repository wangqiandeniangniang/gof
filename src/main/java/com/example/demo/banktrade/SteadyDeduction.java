package com.example.demo.banktrade;

/**
 * @ClassName SteadyDeduction
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:28
 * @Version 1.0
 **/
public class SteadyDeduction implements IDeduction {

    //固定性交易扣款
    @Override
    public boolean exec(Card card, Trade trade) {
        //固定金额和自由金额各扣除50%
        int halfMoney = (int)Math.rint(trade.getAmount() / 2.0);
        card.setFreeMoney(card.getFreeMoney() - halfMoney);
        card.setSteadyMoney(card.getSteadyMoney() - halfMoney);
        return true;
    }
}
