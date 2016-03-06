package com.ubs.opsit.interviews.converters;

import com.ubs.opsit.interviews.validator.BerlinClockTimeValidator;
import org.apache.commons.lang.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.ubs.opsit.interviews.utils.BerlinClockConverterUtils.*;

public class BerlinClockMinutesConverter implements MinutesConverter {
    public static final int QUARTER_FACTOR = 3;
    public static final int ELEVEN_DIGITS_DISPLAY = 11;


    @Override
    public String convertMinutes(int minutes) {
        if (BerlinClockTimeValidator.getInstance().validateMinutes(minutes)) {
            StringBuilder output = new StringBuilder();
            output.append(convertToElevenDigitsLine(Math.round(minutes / CLOCK_DISPLAY_FACTOR)));
            output.append(NEW_LINE);
            output.append(convertToFourDigitsLine(minutes % CLOCK_DISPLAY_FACTOR, Y));
            return output.toString();
        } else {
            return StringUtils.EMPTY;
        }
    }

    private String convertToElevenDigitsLine(int factor) {
        return StringUtils.rightPad(IntStream.range(0, factor).mapToObj(this::convertQuarterPartOutput).collect(Collectors.joining()), ELEVEN_DIGITS_DISPLAY, O_CHAR);
    }

    private String convertQuarterPartOutput(int counter) {
        if (isQuarterDigit(counter)) {
            return R;
        } else {
            return Y;
        }
    }

    private boolean isQuarterDigit(int digitPositionCountedFromZero) {
        return (digitPositionCountedFromZero + 1) % QUARTER_FACTOR == 0;
    }
}
