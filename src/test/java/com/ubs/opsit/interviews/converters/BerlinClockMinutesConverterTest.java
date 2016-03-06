package com.ubs.opsit.interviews.converters;

import com.ubs.opsit.interviews.utils.BerlinClockConverterUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerlinClockMinutesConverterTest {
    MinutesConverter minutesConverter = new BerlinClockMinutesConverter();

    @Test
    public void testConvertMinutes() throws Exception {
        //given
        Integer minutes = 59;
        Integer minutesBad = 199;

        //when
        String result = minutesConverter.convertMinutes(minutes);
        String resultBad = minutesConverter.convertMinutes(minutesBad);

        //then
        assertEquals("YYRYYRYYRYY" + BerlinClockConverterUtils.NEW_LINE +
                "YYYY", result);
        assertEquals("", resultBad);
    }
}