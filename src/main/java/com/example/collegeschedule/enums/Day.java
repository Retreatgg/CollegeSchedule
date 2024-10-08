package com.example.collegeschedule.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@Getter
@RequiredArgsConstructor
public enum Day {
    MONDAY("ПОНЕДЕЛНИК"),
    TUESDAY("ВТОРНИК"),
    WEDNESDAY("СРЕДА"),
    THURSDAY("ЧЕТВЕРГ"),
    FRIDAY("ПЯТНИЦА");

    private final String day;

    public static Day getDay(String day) {
        return switch (day.toUpperCase()) {
            case "ПОНЕДЕЛНИК" -> MONDAY;
            case "ВТОРНИК" -> TUESDAY;
            case "СРЕДА" -> WEDNESDAY;
            case "ЧЕТВЕРГ" -> THURSDAY;
            case "ПЯТНИЦА" -> FRIDAY;
         //   case "ВОСКРЕСЕНЬЕ" -> SUNDAY;
            default -> throw new NoSuchElementException(String.format("No such day: '%s'", day));
        };
    }

    @Override
    public String toString() {
        return day;
    }
}
