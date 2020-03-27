package com.ml.sinon.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liangzhong.tan
 * date 2020/3/20 16:16
 */
@Slf4j
@Data
@AllArgsConstructor
public class Motor {

    private String type;

    private String brand;

    private Integer price;

    public static void main(String[] args) {
//    Collectors.groupingBy

        List<Motor> motors = Arrays.asList(
                new Motor("H2", "kawasaki", 23),
                new Motor("Ninja400", "kawasaki", 5),
                new Motor("Ninja250", "kawasaki", 4),
                new Motor("RS1200GS DAV", "BWM", 23),
                new Motor("NK250", "CF", 2),
                new Motor("GSX250", "SUZUKI", 3),
                new Motor("DL250", "SUZUKI", 3)
        );

        // 分组 ,
        Map<String, List<Motor>> motorMap =motors.stream().collect(Collectors.groupingBy(Motor::getBrand));
        log.info("motorMap: {}", motorMap);

        // 分组 - 转换结果集 ,
        Map<String, List<String>> typeMap =motors.stream().collect(Collectors.groupingBy(Motor::getBrand,Collectors.mapping(Motor::getType, Collectors.toList())));
        log.info("typeMap: {}", typeMap);

        // 分组-计数
        Map<String, Long> countMap = motors.stream().collect(Collectors.groupingBy(Motor::getBrand, Collectors.counting()));
        log.info("countMap: {}", countMap);

        // 排序
        countMap.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(System.out::println);

        // 分组-求和
        Map<String, Integer> sumMap = motors.stream().collect(Collectors.groupingBy(Motor::getBrand, Collectors.summingInt(Motor::getPrice)));
        log.info("sumMap: {}", sumMap);

    }
}


