package com.ubs.opsit.interviews.validator;

public interface TimeValidator {
    Boolean validate(String inputTime);
    Boolean validateMinutes(int minutes);
    Boolean validateHours(int hours);
    Boolean validateSeconds(int seconds);
}
