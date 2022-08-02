/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ValidUtils {

    public static Date isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        Date date = null;

        try {
            date = new java.sql.Date(dateFormat.parse(inDate.trim()).getTime());
        } catch (ParseException pe) {
            date = null;
        }
        return date;
    }

    private static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

    public static String parseDate(Date inDate) {
        LocalDate localDate = inDate.toLocalDate();
        int year = localDate.getYear();
        String month = Integer.toString(localDate.getMonthValue());
        String day = Integer.toString(localDate.getDayOfMonth());

        return year + "-" + padLeftZeros(month, 2) + "-" + padLeftZeros(day, 2);
    }

    public static boolean isValidInt(String str) {
        return str.matches("[0-9]+");
    }

    public static boolean isValidFloat(String str) {
        return str.matches("[+-]?([0-9]*[.])?[0-9]+");
    }
}
