package com.ubs.opsit.interviews.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class BerlinClockConverterUtilsTest {

    @Test
    public void testIsEven() throws Exception {
        //given
        Integer even = 2;

        //when
        boolean result = BerlinClockConverterUtils.isEven(even);

        //then
        assertTrue(result);
    }

    @Test
    public void testIsOdd() throws Exception {
        //given
        Integer odd = 1;

        //when
        boolean result = BerlinClockConverterUtils.isEven(odd);

        //then
        assertFalse(result);
    }

    @Test
    public void testConvertToFourDigitsLine(){
        //given
        Integer factor = 3;
        String value = "X";

        //when
        String result = BerlinClockConverterUtils.convertToFourDigitsLine(factor, value);

        //then
        assertEquals("XXXO", result);
    }
}