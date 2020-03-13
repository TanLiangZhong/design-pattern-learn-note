package com.ml.sinon.common.annotation.matcher.impl;

import com.ml.sinon.common.annotation.Operation;
import com.ml.sinon.common.annotation.matcher.Matcher;
import org.springframework.stereotype.Component;

/**
 * 运算方式枚举匹配
 *
 * @author liangzhong.tan
 * date 2020/3/12 15:41
 */
@Component
public class OperationMatcher implements Matcher<Operation> {
    @Override
    public boolean match(Operation annotation, Object... values) {
        if (annotation == null || values == null || values.length < 1) {
            return false;
        }
        return annotation.value().getCode().equals(values[0]);
    }
}
