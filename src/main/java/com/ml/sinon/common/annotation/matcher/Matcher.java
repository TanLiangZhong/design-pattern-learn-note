package com.ml.sinon.common.annotation.matcher;

import java.lang.annotation.Annotation;

/**
 * 注解接口匹配器接口
 *
 * @author liangzhong.tan
 * date 2020/3/12 15:41
 */
public interface Matcher<T extends Annotation> {
    /**
     * 注解与待校验值是否一致
     *
     * @param annotation 注解
     * @param values     待校验值
     * @return boolean
     */
    boolean match(T annotation, Object... values);
}
