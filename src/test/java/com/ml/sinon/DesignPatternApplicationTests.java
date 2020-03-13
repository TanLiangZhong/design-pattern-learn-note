package com.ml.sinon;

import com.ml.sinon.pattern.strategy.StrategyPatternDemo;
import com.ml.sinon.pattern.template.TemplatePatternDemo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignPatternApplicationTests {

    @Test
    void contextLoads() {
        // 执行策略模式Demo
        StrategyPatternDemo.run();

        // 执行模板模式Demo
        TemplatePatternDemo.run();
    }

}
