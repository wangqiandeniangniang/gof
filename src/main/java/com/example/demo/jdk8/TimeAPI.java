package com.example.demo.jdk8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName TimeAPI
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/12/4 9:19
 * @Version 1.0
 **/
public class TimeAPI {
    public static void main(String[] args) {

        //Clock 提供了对当前时间和日期的访问功能
        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();
        Date date = Date.from(instant);

        //Timezones 时区类
        System.out.println(ZoneId.getAvailableZoneIds());
        //prints all available timezone ids
        ZoneId berlin = ZoneId.of("Europe/Berlin");
        ZoneId east = ZoneId.of("Brazil/East");
        System.out.println(berlin.getRules());
        System.out.println(east.getRules());

        // LocalTime 本地时间类表示一个没有指定时区的时间
        LocalTime berlinNow = LocalTime.now(berlin);
        LocalTime eastNow = LocalTime.now(east);
        System.out.println(berlinNow.isBefore(eastNow));

        long hourBetween = ChronoUnit.HOURS.between(berlinNow, eastNow);
        long minuteBetween = ChronoUnit.MINUTES.between(berlinNow, eastNow);

        LocalTime late = LocalTime.of(23, 59, 59);

        DateTimeFormatter germanFormatter = DateTimeFormatter
                .ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.GERMAN);
        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);


        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);

        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);

        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);

        //LocalDateTime 是不可变的

        LocalDateTime now = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        DayOfWeek nowDayOfWeek = now.getDayOfWeek();
        System.out.println(nowDayOfWeek);

        Month month = now.getMonth();
        System.out.println(month);

        long minuteOfDay = now.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        Instant instant1 = now.atZone(ZoneId.systemDefault())
                .toInstant();
        Date from = Date.from(instant);
        System.out.println(from);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("MMM dd, yyyy - HH:mm");
        LocalDateTime parse = LocalDateTime.parse("Nov 03, 2014 - 07:13", dateTimeFormatter);
        String format = dateTimeFormatter.format(parse);
        System.out.println(format);
    }
}
