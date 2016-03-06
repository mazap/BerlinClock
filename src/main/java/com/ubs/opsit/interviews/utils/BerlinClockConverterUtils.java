package com.ubs.opsit.interviews.utils;

import org.apache.commons.lang.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BerlinClockConverterUtils {
    public static final String NEW_LINE = "\r\n";
    public static final int FOUR_DIGITS_DISPLAY = 4;
    public static final char O_CHAR = 'O';
    public static final String Y = "Y";
    public static final String O = "O";
    public static final String R = "R";
    public static final int CLOCK_DISPLAY_FACTOR = 5;

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static String convertToFourDigitsLine(int factor, String value) {
        return StringUtils.rightPad(IntStream.range(0, factor).mapToObj((i) -> value).collect(Collectors.joining()), FOUR_DIGITS_DISPLAY, O_CHAR);
    }
}
