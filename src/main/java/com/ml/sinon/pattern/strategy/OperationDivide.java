package com.ml.sinon.pattern.strategy;

import com.ml.sinon.common.annotation.Operation;
import com.ml.sinon.common.enums.OperationEnum;
import org.springframework.stereotype.Service;

/**
 * 除
 *
 * @author liangzhong.tan
 * date 2020/3/12 16:33
 */
@Service
@Operation(value = OperationEnum.DIVIDE)
public class OperationDivide implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 / num2;
    }
}
