package com.ml.sinon.common.annotation;


import com.ml.sinon.common.enums.OperationEnum;

import java.lang.annotation.*;

/**
 * 运算方式
 *
 * @author liangzhong.tan
 * date 2020/3/12 16:19
 */
@Inherited
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Operation {
    OperationEnum value();
}
