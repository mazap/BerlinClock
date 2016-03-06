package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.converters.*;
import com.ubs.opsit.interviews.domain.Time;
import com.ubs.opsit.interviews.exception.InvalidInputTimeFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.ubs.opsit.interviews.utils.BerlinClockConverterUtils.NEW_LINE;

public class BerlinClockConverter implements TimeConverter {
    private final static Logger LOG = LoggerFactory.getLogger(BerlinClockConverter.class);

    private final MinutesConverter minutesConverter;
    private final HoursConverter hoursConverter;
    private final SecondsConverter secondsConverter;

    private BerlinClockConverter(BerlinClockConverterBuilder builder) {
        this.hoursConverter = builder.hoursConverter;
        this.minutesConverter = builder.minutesConverter;
        this.secondsConverter = builder.secondsConverter;
    }

    @Override
    public String convertTime(String aTime) {
        LOG.debug("Conversion started");
        final StringBuilder output = new StringBuilder();
        final Time time;
        try {
            time = TimeLoader.loadTime(aTime);
        } catch (InvalidInputTimeFormatException exception) {
            LOG.error(exception.getMessage(), exception);
            return null;
        }
        LOG.debug("Time loaded");

        appendSeconds(output, time.getSeconds());
        appendHours(output, time.getHours());
        appendMinutes(output, time.getMinutes());

        LOG.debug(output.toString());
        return output.toString();
    }

    private void appendSeconds(StringBuilder output, int seconds) {
        output.append(secondsConverter.convertSeconds(seconds));
        output.append(NEW_LINE);
        LOG.debug("Seconds applied");
    }

    private void appendHours(StringBuilder output, int hours) {
        output.append(hoursConverter.convertHours(hours));
        output.append(NEW_LINE);
        LOG.debug("Hours applied");
    }

    private void appendMinutes(StringBuilder output, int minutes) {
        output.append(minutesConverter.convertMinutes(minutes));
        LOG.debug("Minutes applied");
    }

    public static class BerlinClockConverterBuilder {
        private static final String CONVERTERS_NOT_INITIALIZED = "Converters not initialized";
        private final MinutesConverter minutesConverter;
        private final HoursConverter hoursConverter;
        private final SecondsConverter secondsConverter;

        public BerlinClockConverterBuilder(HoursConverter hoursConverter, MinutesConverter minutesConverter, SecondsConverter secondsConverter) {
            this.minutesConverter = minutesConverter;
            this.hoursConverter = hoursConverter;
            this.secondsConverter = secondsConverter;
        }

        public BerlinClockConverterBuilder() {
            this.hoursConverter = new BerlinClockHoursConverter();
            this.minutesConverter = new BerlinClockMinutesConverter();
            this.secondsConverter = new BerlinClockSecondsConverter();
        }

        public BerlinClockConverter build() {
            if(hoursConverter == null || minutesConverter == null || secondsConverter == null) {
                throw new IllegalStateException(CONVERTERS_NOT_INITIALIZED);
            }
            return new BerlinClockConverter(this);
        }
    }

}
