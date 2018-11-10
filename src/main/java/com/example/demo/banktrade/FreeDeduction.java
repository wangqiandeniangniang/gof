package com.example.demo.banktrade;

/**
 * @ClassName FreeDeduction
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:35
 * @Version 1.0
 **/
public class FreeDeduction implements IDeduction {
    //自由扣款
    @Override
    public boolean exec(Card card, Trade trade) {
        //直接从自由余额中扣除
        card.setFreeMoney(card.getFreeMoney() - trade.getAmount());
        return true;
    }
}
