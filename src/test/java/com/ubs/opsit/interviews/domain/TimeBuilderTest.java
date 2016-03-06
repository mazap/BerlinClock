package com.ubs.opsit.interviews.domain;


import org.junit.Assert;
import org.junit.Test;

public class TimeBuilderTest {

    @Test
    public void testBuild() throws Exception {
        //given
        Time time;

        //when
        time = new Time.TimeBuilder(1,2,3).build();

        //then
        Assert.assertTrue(time.getHours() == 1);
        Assert.assertTrue(time.getMinutes() == 2);
        Assert.assertTrue(time.getSeconds() == 3);
    }

}