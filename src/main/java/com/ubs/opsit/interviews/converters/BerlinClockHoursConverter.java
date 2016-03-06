package com.ubs.opsit.interviews.converters;

import com.ubs.opsit.interviews.validator.BerlinClockTimeValidator;
import org.apache.commons.lang.StringUtils;

import static com.ubs.opsit.interviews.utils.BerlinClockConverterUtils.*;

public class BerlinClockHoursConverter implements HoursConverter {
    @Override
    public String convertHours(int hours) {
        if(BerlinClockTimeValidator.getInstance().validateHours(hours)) {
            StringBuilder output = new StringBuilder();
            output.append(convertToFourDigitsLine(Math.round(hours / CLOCK_DISPLAY_FACTOR), R));
            output.append(NEW_LINE);
            output.append(convertToFourDigitsLine(hours % CLOCK_DISPLAY_FACTOR, R));
            return output.toString();
        } else {
            return StringUtils.EMPTY;
        }
    }
}
