package com.ml.sinon.pattern.strategy;

import com.ml.sinon.common.SpringContextHolder;
import com.ml.sinon.common.annotation.Operation;
import com.ml.sinon.common.annotation.matcher.Matcher;
import com.ml.sinon.common.annotation.matcher.impl.OperationMatcher;
import com.ml.sinon.common.enums.OperationEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

/**
 * 执行策略模式 Demo
 *
 * @author liangzhong.tan
 * date 2020/3/12 15:41
 */
@Slf4j
public class StrategyPatternDemo {

    public static void run() {
        Matcher<Operation> matcher = new OperationMatcher();
        Stream.of(OperationEnum.values()).forEach(operation -> {
            try {
                Strategy strategy = SpringContextHolder.getBeanByAnnotation(Strategy.class, Operation.class, matcher, operation.getCode());
                log.info("10 {} 2 = {}", operation.getText(), strategy.doOperation(10, 2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void runNewBean() {
        OperationContext context = new OperationContext(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new OperationContext(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new OperationContext(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
