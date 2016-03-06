package com.ubs.opsit.interviews.converters;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerlinClockSecondsConverterTest {
    SecondsConverter secondsConverter = new BerlinClockSecondsConverter();

    @Test
    public void testConvertSeconds() throws Exception {
        //given
        Integer secondsEven = 2;
        Integer secondsOdd = 11;

        //when
        String resultEven = secondsConverter.convertSeconds(secondsEven);
        String resultOdd = secondsConverter.convertSeconds(secondsOdd);

        //then
        assertEquals("Y", resultEven);
        assertEquals("O", resultOdd);
    }
}