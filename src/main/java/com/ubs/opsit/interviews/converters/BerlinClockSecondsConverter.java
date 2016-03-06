package com.ubs.opsit.interviews.converters;

import com.ubs.opsit.interviews.validator.BerlinClockTimeValidator;
import org.apache.commons.lang.StringUtils;

import static com.ubs.opsit.interviews.utils.BerlinClockConverterUtils.*;

public class BerlinClockSecondsConverter implements SecondsConverter {
    @Override
    public String convertSeconds(int seconds) {
        if (BerlinClockTimeValidator.getInstance().validateSeconds(seconds)) {
            StringBuilder output = new StringBuilder();
            output.append(isEven(seconds) ? Y : O);
            return output.toString();
        } else {
            return StringUtils.EMPTY;
        }
    }

}
