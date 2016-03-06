package com.ubs.opsit.interviews.converters;

import com.ubs.opsit.interviews.utils.BerlinClockConverterUtils;
import junit.framework.TestCase;

public class BerlinClockHoursConverterTest extends TestCase {
    HoursConverter hoursConverter = new BerlinClockHoursConverter();

    public void testConvertHours() throws Exception {
        //given
        Integer hours = 3;
        Integer hoursBad = 28;

        //when
        String result = hoursConverter.convertHours(hours);
        String resultBad = hoursConverter.convertHours(hoursBad);

        //then
        assertEquals("OOOO" + BerlinClockConverterUtils.NEW_LINE + "RRRO", result);
        assertEquals("", resultBad);
    }
}