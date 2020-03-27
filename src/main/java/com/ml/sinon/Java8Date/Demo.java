package com.ml.sinon.Java8Date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author liangzhong.tan
 * date 2020/3/27 14:45
 */
public class Demo {

    public static void main(String[] args) {


        // 获取当前的日期时间
        System.out.println("Create LocalDateTime_1: " + LocalDateTime.now());

        // 通过 LocalDate, LocalTime 获得 LocalDateTime
        System.out.println("Create LocalDateTime_2: " + LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        // 指定年月日时分秒 获得 LocalDateTime
        System.out.println("Create LocalDateTime_3: " + LocalDateTime.of(1997, 11, 17, 11, 11, 11));

        // 指定时区 获得 LocalDateTime
        System.out.println("Create LocalDateTime_4: " + LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Shanghai")));


        LocalDateTime today = LocalDateTime.now();

        //时间加减 加 plus,  减 minus
        System.out.println("1 年后 " + today.plusYears(1));
        System.out.println("1 天后 " + today.plusDays(1));
        System.out.println("1 年前 " + today.minusYears(1));
        System.out.println("1 周前 " + today.minusWeeks(1));
        System.out.println("1 月前 " + today.minusMonths(1));

        // 时间比较
        System.out.println("是否相等: " + today.isEqual(today.minusDays(1)));
        System.out.println("Today之前: " + today.isAfter(today.minusDays(1)));
        System.out.println("Today之后: " + today.isBefore(today.minusDays(1)));


        // 调整日期时间
        System.out.println("年调整至 1997 年:   " + today.withYear(1997));
        System.out.println("月调整 2 月: " + today.withMonth(2));
        System.out.println("每月的第一天: " + today.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("下个月的第一天: " + today.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("每年的最后一天: " + today.with(TemporalAdjusters.lastDayOfYear()));

        // 判断是否是闰年
        System.out.println("是否是闰年: " + today.toLocalDate().isLeapYear());

        //两个日期间的间隔
        System.out.println("今天与月末相差多少天: " + today.until(today.with(TemporalAdjusters.lastDayOfMonth()), ChronoUnit.DAYS));

//        LocalDateTime today = LocalDateTime.now();
        System.out.println("LocalDateTime 格式化: " + today.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));

        Date date = new Date();

        // java.util.Date 转换为  LocalDateTime 指定时区 CTT
        ZoneId ctt = ZoneId.of(ZoneId.SHORT_IDS.get("CTT"));
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ctt);
        System.out.println("java.util.Date 转换为  LocalDateTime, 指定时区: " + localDateTime);

        // java.util.Date 转换为  LocalDateTime 系统默认时区
        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println("java.util.Date 转换为  LocalDateTime, 系统默认时区: " + LocalDateTime.ofInstant(date.toInstant(), defaultZone));

        //LocalDateTime 转换为 java.util.Date 指定时区
        System.out.println("LocalDateTime 转换为 java.util.Date, 指定时区: " + Date.from(localDateTime.atZone(ctt).toInstant()));

        //LocalDateTime 转换为 java.util.Date 系统默认时区
        System.out.println("LocalDateTime 转换为 java.util.Date, 系统默认时区: " + Date.from(localDateTime.atZone(defaultZone).toInstant()));

        // LocalDateTime 转换为 String
        System.out.println("LocalDateTime 转换为 String: "+ today.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
        System.out.println("LocalDateTime 转换为 String: "+ today.format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
        System.out.println("LocalDateTime 转换为 String: "+ today.format(DateTimeFormatter.ofPattern("MM-dd HH:mm")));


        // String 转换为 LocalDateTime
        System.out.println("String 转换为 LocalDateTime : " + LocalDateTime.parse("1997-11-17 11:11:11", DateTimeFormatter.ofPattern("yyyy-MM-dd[[ HH][:mm][:ss]]")));
        System.out.println("String 转换为 LocalDateTime : " + LocalDate.parse("1997-11-17", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("String 转换为 LocalDateTime : " + LocalTime.parse("11:11:11", DateTimeFormatter.ofPattern("HH:mm:ss")));

        // 当String类型时间没有时分秒时, DateTimeFormatter 需要设置默认值.
        final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd[[ HH][:mm][:ss]]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)    // 时
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0) // 分
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)   // 秒
                .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)    // 毫秒
                .toFormatter();
        System.out.println("String 转换为 LocalDateTime : " + LocalDateTime.parse("1997-11-17", formatter));

    }

}
