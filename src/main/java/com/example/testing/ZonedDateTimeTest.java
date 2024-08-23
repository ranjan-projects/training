package com.example.testing;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeTest {

    public static void main(String[] args) {

        ZonedDateTime datetime = ZonedDateTime.of(
                        LocalDate.of(2022, Month.JULY, 12),
                        LocalTime.of(10,12),
                        ZoneId.of("Europe/London")
        );

        System.out.println(datetime);
        System.out.println(datetime.withZoneSameInstant(ZoneId.of("US/Central")));

        System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(datetime));

    }

}
