package com.ubs.opsit.interviews.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BerlinClockTimeValidator implements TimeValidator {
    private static final BerlinClockTimeValidator INSTANCE = new BerlinClockTimeValidator();
    public static final int MINUTES_SEC_MIN = 0;
    public static final int MINUTES_SEC_MAX = 59;
    public static final int HOURS_MIN = 0;
    public static final int HOURS_MAX = 24;
    private static final String ALREADY_INSTANTIATED = "Already instantiated";

    private static final String TIME_24HOURS_PATTERN =
            "(([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9])|(24:00:00)";
    private final Pattern pattern = Pattern.compile(TIME_24HOURS_PATTERN);

    private BerlinClockTimeValidator() {
        if (INSTANCE != null) {
            throw new IllegalStateException(ALREADY_INSTANTIATED);
        }
    }

    public static BerlinClockTimeValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public Boolean validate(String inputTime) {
        Matcher matcher = pattern.matcher(inputTime);
        return matcher.matches();
    }

    @Override
    public Boolean validateMinutes(int minutes) {
        return minutes >= MINUTES_SEC_MIN && minutes <= MINUTES_SEC_MAX;
    }

    @Override
    public Boolean validateHours(int hours) {
        return hours >= HOURS_MIN && hours <= HOURS_MAX;
    }

    @Override
    public Boolean validateSeconds(int seconds) {
        return seconds >= MINUTES_SEC_MIN && seconds <= MINUTES_SEC_MAX;
    }
}
