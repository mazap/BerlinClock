package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.converters.BerlinClockHoursConverter;
import com.ubs.opsit.interviews.converters.BerlinClockMinutesConverter;
import com.ubs.opsit.interviews.converters.BerlinClockSecondsConverter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerlinClockConverterTest {
    BerlinClockConverter converter = new BerlinClockConverter.BerlinClockConverterBuilder().build();

    @Test
    public void testConvertTimeMidnight() throws Exception {
        //given
        String midnight = "00:00:00";

        //when
        String output = converter.convertTime(midnight);

        //then
        String expected = "Y\r\n" +
                "OOOO\r\n" +
                "OOOO\r\n" +
                "OOOOOOOOOOO\r\n" +
                "OOOO";
        assertEquals(expected, output);
    }

    @Test
    public void testConvertTimeMorning() throws Exception {
        //given
        String midnight = "11:12:13";

        //when
        String output = converter.convertTime(midnight);

        //then
        String expected = "O\r\n" +
                "RROO\r\n" +
                "ROOO\r\n" +
                "YYOOOOOOOOO\r\n" +
                "YYOO";
        assertEquals(expected, output);
    }

    @Test
    public void testConvertAlternativeMidnight() throws Exception {
        //given
        String midnight = "24:00:00";

        //when
        String output = converter.convertTime(midnight);

        //then
        String expected = "Y\r\n" +
                "RRRR\r\n" +
                "RRRR\r\n" +
                "OOOOOOOOOOO\r\n" +
                "OOOO";
        assertEquals(expected, output);
    }

    @Test
    public void testConvertAlmostMidnight() throws Exception {
        //given
        String midnight = "23:59:59";

        //when
        String output = converter.convertTime(midnight);

        //then
        String expected = "O\r\n" +
                "RRRR\r\n" +
                "RRRO\r\n" +
                "YYRYYRYYRYY\r\n" +
                "YYYY";
        assertEquals(expected, output);
    }

    @Test
    public void testBuildOK() throws Exception{
        //given
        BerlinClockConverter converter;
        BerlinClockConverter converterDefault;

        //when
        converter = new BerlinClockConverter.BerlinClockConverterBuilder(new BerlinClockHoursConverter(),
                new BerlinClockMinutesConverter(),
                new BerlinClockSecondsConverter()).build();
        converterDefault = new BerlinClockConverter.BerlinClockConverterBuilder().build();

        //then
        Assert.assertNotNull(converter);
        Assert.assertNotNull(converterDefault);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildNulls() {
        //given
        BerlinClockConverter converter;

        //when
        converter = new BerlinClockConverter.BerlinClockConverterBuilder(new BerlinClockHoursConverter(),
                null,
                new BerlinClockSecondsConverter()).build();

        //then
        Assert.assertNotNull(converter);
    }
}

