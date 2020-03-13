package com.ml.sinon.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 运算方式枚举
 *
 * @author liangzhong.tan
 * date 2020/3/12 16:19
 */
@Getter
@AllArgsConstructor
public enum OperationEnum {

    ADD("ADD", "加"),
    SUBTRACT("SUBTRACT", "减"),
    MULTIPLY("MULTIPLY", "乘"),
    DIVIDE("DIVIDE", "除");

    private String code;
    private String text;

}
