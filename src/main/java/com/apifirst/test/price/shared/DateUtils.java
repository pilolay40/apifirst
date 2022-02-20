package com.apifirst.test.price.shared;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    public static LocalDateTime convertStringToLocalDate(final String date) {
        return LocalDateTime.parse(date, FORMATTER);
    }

}
