package com.example.demo.banktrade;

/**
 * @ClassName DeductionFacde
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:48
 * @Version 1.0
 **/
public class DeductionFacde {
    //对外公布的扣款信息
    public static Card deduct(Card card, Trade trade) {
        //获取消费策略对象
        StrategyMan reg = getDeductionType(trade);
        //初始化一个消费策略对象
        IDeduction deduction = StratetegyFactory.getDeduction(reg);
        //产生一个策略上下文
        DeductionContext deductionContext = new DeductionContext(deduction);
        //进行扣款处理
        deductionContext.exec(card, trade);
        //返回扣款处理完毕后的数据
        return card;
    }

    //获取对应的商户消费策略
    private static StrategyMan getDeductionType(Trade trade) {
        //模拟操作
        if (trade.getTradeNo().contains("abc")) {
            return StrategyMan.FreeDeduction;
        } else {
            return StrategyMan.SteadyDeduction;
        }
    }
}
