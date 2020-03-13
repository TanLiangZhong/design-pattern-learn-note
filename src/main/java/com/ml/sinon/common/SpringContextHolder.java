package com.ml.sinon.common;

import com.ml.sinon.common.annotation.matcher.Matcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class SpringContextHolder implements ApplicationContextAware {
    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return ac.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return ac.getBean(name, clazz);
    }

    /**
     * 获取指定的bean
     *
     * @param clazz   bean的类型
     * @param atClass bean需要包含的注解的类型
     * @param matcher 注解匹配类
     * @param values  需要匹配的值
     * @param <T>     bean的类型
     * @param <A>     bean的注解的类型
     * @return bean
     */
    public static <T, A extends Annotation> T getBeanByAnnotation(Class<T> clazz, Class<A> atClass, Matcher<A> matcher, Object... values) throws Exception {
        Map<String, T> map = ac.getBeansOfType(clazz);
        if (CollectionUtils.isEmpty(map)) {
            log.error("bean不存在;annotation:{},class:{},matcher:{},values:{}", atClass.getSimpleName(), clazz.getSimpleName(), matcher.getClass().getSimpleName(), values);
        }
        List<T> list = new ArrayList<>();
        map.values().forEach(bean -> {
            A at = bean.getClass().getAnnotation(atClass);
            if (matcher.match(at, values)) {
                list.add(bean);
            }
        });
        if (list.isEmpty()) {
            log.error("bean不存在;annotation:{},class:{},matcher:{},values:{}", atClass.getSimpleName(), clazz.getSimpleName(), matcher.getClass().getSimpleName(), values);
            throw new Exception("Bean does not exist");
        }
        if (list.size() > 1) {
            log.error("匹配到多个bean;annotation:{},class:{},matcher:{},values:{}", atClass.getSimpleName(), clazz.getSimpleName(), matcher.getClass().getSimpleName(), values);
            throw new Exception("Matching to multiple beans");
        }
        return list.get(0);
    }

}
