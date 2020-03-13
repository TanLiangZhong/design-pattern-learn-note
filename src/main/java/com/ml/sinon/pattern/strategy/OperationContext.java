package com.ml.sinon.pattern.strategy;

import java.math.BigDecimal;

/**
 * @author liangzhong.tan
 * date 2020/3/12 15:41
 */
public class OperationContext {
    private Strategy strategy;

    public OperationContext(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        BigDecimal a = new BigDecimal(1);
        return strategy.doOperation(num1, num2);
    }
}
