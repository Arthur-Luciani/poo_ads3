package com.br.ifsc.pousada.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtil {

    private static final String FORMAT = "dd/MM/yyyy";

    public static String getStringFromDate(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);
        return localDate.format(formatter);
    }

    public static LocalDate getDateFromString(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);
        return LocalDate.parse(date, formatter);
    }
}
