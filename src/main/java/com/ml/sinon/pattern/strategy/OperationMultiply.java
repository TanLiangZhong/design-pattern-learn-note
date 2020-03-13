package com.ml.sinon.pattern.strategy;

import com.ml.sinon.common.annotation.Operation;
import com.ml.sinon.common.enums.OperationEnum;
import org.springframework.stereotype.Service;

/**
 * 乘
 * @author liangzhong.tan
 * date 2020/3/12 15:39
 */
@Service
@Operation(value = OperationEnum.MULTIPLY)
public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
