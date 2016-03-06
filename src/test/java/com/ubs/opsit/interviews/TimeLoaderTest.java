package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.domain.Time;
import com.ubs.opsit.interviews.exception.InvalidInputTimeFormatException;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertTrue;

public class TimeLoaderTest {

    @Test(expected=InvalidInputTimeFormatException.class)
    public void testLoadGoodTime() throws Exception {
        //given
        String goodTime = "22:23:24";
        String midnight = "00:00:00";
        String alternativeMidnight = "24:00:00";

        //when
        Calendar calendarGoodTime = TimeLoader.loadTime(goodTime, null);
        Time goodTimeParsed = TimeLoader.loadTime(goodTime);
        Calendar calendarMidnight = TimeLoader.loadTime(midnight, null);
        Time midnightTime = TimeLoader.loadTime(midnight);
        Time alternativeMidnightTime = TimeLoader.loadTime(alternativeMidnight);

        //then
        assertTrue(calendarGoodTime.get(Calendar.HOUR_OF_DAY) == 22);
        assertTrue(calendarGoodTime.get(Calendar.MINUTE) == 23);
        assertTrue(calendarGoodTime.get(Calendar.SECOND) == 24);

        assertTrue(goodTimeParsed.getHours() == 22);
        assertTrue(goodTimeParsed.getMinutes() == 23);
        assertTrue(goodTimeParsed.getSeconds() == 24);

        assertTrue(calendarMidnight.get(Calendar.HOUR_OF_DAY) == 00);
        assertTrue(calendarMidnight.get(Calendar.MINUTE) == 00);
        assertTrue(calendarMidnight.get(Calendar.SECOND) == 00);

        assertTrue(midnightTime.getHours() == 00);
        assertTrue(midnightTime.getMinutes() == 00);
        assertTrue(midnightTime.getSeconds() == 00);

        assertTrue(alternativeMidnightTime.getHours() == 24);
        assertTrue(alternativeMidnightTime.getMinutes() == 00);
        assertTrue(alternativeMidnightTime.getSeconds() == 00);

        Calendar calendarAlternativeMidnight = TimeLoader.loadTime(alternativeMidnight, null);
    }

    @Test(expected=InvalidInputTimeFormatException.class)
    public void testLoadBadFormatTimeCalendar() throws Exception {
        //given
        String badTime = "224:23:24";

        //when
        Calendar time = TimeLoader.loadTime(badTime, null);
    }

    @Test(expected=InvalidInputTimeFormatException.class)
    public void testLoadBadFormatTime() throws Exception {
        //given
        String badTime = "224:23:24";

        //when
        Time time = TimeLoader.loadTime(badTime);
    }

    @Test(expected=InvalidInputTimeFormatException.class)
    public void testLoadBadFormatTimeText() throws Exception {
        //given
        String badTime = "blablablaaba";

        //when
        Time time = TimeLoader.loadTime(badTime);
    }
}