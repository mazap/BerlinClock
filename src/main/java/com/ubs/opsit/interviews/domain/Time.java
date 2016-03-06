package com.ubs.opsit.interviews.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Time {
    private final int hours;
    private final int minutes;
    private final int seconds;

    private Time(TimeBuilder builder) {
        this.hours = builder.hours;
        this.minutes = builder.minutes;
        this.seconds = builder.seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public static class TimeBuilder {
        private final int hours;
        private final int minutes;
        private final int seconds;

        public TimeBuilder(int hours, int minutes, int seconds) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public Time build() {
            return new Time(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        return new EqualsBuilder()
                .append(hours, time.hours)
                .append(minutes, time.minutes)
                .append(seconds, time.seconds)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(hours)
                .append(minutes)
                .append(seconds)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Time{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}
