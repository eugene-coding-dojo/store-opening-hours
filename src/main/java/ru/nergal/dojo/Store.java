package ru.nergal.dojo;

import java.time.LocalDate;

public class Store {
    private final String weekdaysOpen;
    private final String weekdaysClose;

    public Store(String weekdaysSchedule) {
        final String[] weekdaysHours = weekdaysSchedule.split(" - ");
        this.weekdaysOpen = weekdaysHours[0];
        this.weekdaysClose = weekdaysHours[1];
    }

    public String statusFor(int year, int month, int day, int hour, int minute) {
        final String currentTime = String.format("%02d:%02d", hour, minute);
        final int dayOfWeek = LocalDate.of(year, month, day).getDayOfWeek().getValue();

        if (currentTime.compareTo(weekdaysOpen) < 0) {
            return String.format("Opens at %s", weekdaysOpen);
        } else if (currentTime.compareTo(weekdaysClose) < 0) {
            return String.format("Closes at %s", weekdaysClose);
        } else if (dayOfWeek > 4) {
            return String.format("Opens on Monday at %s", weekdaysOpen);
        } else {
            return String.format("Opens tomorrow at %s", weekdaysOpen);
        }
    }
}