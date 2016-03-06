package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.domain.Time;
import com.ubs.opsit.interviews.exception.InvalidInputTimeFormatException;
import com.ubs.opsit.interviews.validator.BerlinClockTimeValidator;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.TimeValidator;

import java.util.Calendar;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class TimeLoader {
    private static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";
    private static final String SEPARATOR = ":";
    private static final String INVALID_TIME_FORMAT_S_THE_FORMAT_SHOULD_BE_FOLLOWING_S = "Invalid time format: %s. The format should be following %s";

    /**
     * Method not used because of special case 24:00:00 which is not valid case in JAVA
     * Such value is converted to 00:00:00
     *
     * @param aTime
     * @param timeFormat
     * @return
     * @throws InvalidInputTimeFormatException
     */
    public static Calendar loadTime(final String aTime, String timeFormat) throws InvalidInputTimeFormatException {
        Calendar time = TimeValidator.getInstance().validate(aTime, StringUtils.isEmpty(timeFormat) ? DEFAULT_TIME_PATTERN : timeFormat);
        if (time == null) {
            throw new InvalidInputTimeFormatException(String.format(INVALID_TIME_FORMAT_S_THE_FORMAT_SHOULD_BE_FOLLOWING_S, aTime, DEFAULT_TIME_PATTERN));
        } else {
            return time;
        }
    }

    /**
     * Alternative method used to handle defined scenarios including time format 24:00:00.
     *
     * @param aTime
     * @return
     * @throws InvalidInputTimeFormatException
     */
    public static Time loadTime(final String aTime) throws InvalidInputTimeFormatException {
        if (BerlinClockTimeValidator.getInstance().validate(aTime)) {
            Iterator<Integer> iterator = Pattern.compile(SEPARATOR).splitAsStream(aTime).flatMapToInt(n -> IntStream.of(Integer.parseInt(n))).iterator();
            return new Time.TimeBuilder(iterator.next(), iterator.next(), iterator.next()).build();
        } else {
            throw new InvalidInputTimeFormatException(String.format(INVALID_TIME_FORMAT_S_THE_FORMAT_SHOULD_BE_FOLLOWING_S, aTime, DEFAULT_TIME_PATTERN));
        }
    }

}
