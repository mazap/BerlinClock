package com.ubs.opsit.interviews.validator;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class BerlinClockTimeValidatorTest {

    @Test
    public void testValidate() throws Exception {
        //given
        String goodTime = "22:22:22";
        String badTime = "344:34:belbelbe";


        //when
        boolean resultGood = BerlinClockTimeValidator.getInstance().validate(goodTime);
        boolean resultBad = BerlinClockTimeValidator.getInstance().validate(badTime);

        //then
        assertTrue(resultGood);
        assertFalse(resultBad);
    }


    @Test
    public void testValidateMinutes() throws Exception {
        //given
        int minutesGood = 23;
        int minutesBad = -1;

        //when
        boolean resultGood = BerlinClockTimeValidator.getInstance().validateMinutes(minutesGood);
        boolean resultBad = BerlinClockTimeValidator.getInstance().validateMinutes(minutesBad);

        //then
        assertTrue(resultGood);
        assertFalse(resultBad);
    }

    @Test
    public void testValidateHours() throws Exception {
        //given
        int hoursGood = 24;
        int hoursBad = 25;

        //when
        boolean resultGood = BerlinClockTimeValidator.getInstance().validateHours(hoursGood);
        boolean resultBad = BerlinClockTimeValidator.getInstance().validateHours(hoursBad);

        //then
        assertTrue(resultGood);
        assertFalse(resultBad);
    }

    @Test
    public void testValidateSeconds() throws Exception {
        //given
        int secondsGood = 24;
        int secondsBad = 60;

        //when
        boolean resultGood = BerlinClockTimeValidator.getInstance().validateSeconds(secondsGood);
        boolean resultBad = BerlinClockTimeValidator.getInstance().validateSeconds(secondsBad);

        //then
        assertTrue(resultGood);
        assertFalse(resultBad);
    }
}