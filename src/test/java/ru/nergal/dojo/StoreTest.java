package ru.nergal.dojo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StoreTest {

    public static final Store WEEKDAYS_ONLY_10_TO_20 = new Store("10:00 - 20:00");

    public static final Store WEEKDAYS_ONLY_930_TO_1730 = new Store("09:30 - 17:30");

    @Test
    void whenShopIsClosedOnAWorkdayMorning_thenItShouldOpenToday() {
        assertThat(WEEKDAYS_ONLY_10_TO_20.statusFor(2024, 3, 11, 9, 0))
            .isEqualTo("Opens at 10:00");
        assertThat(WEEKDAYS_ONLY_930_TO_1730.statusFor(2024, 3, 11, 8, 0))
            .isEqualTo("Opens at 09:30");
    }

    @Test
    void whenShopIsClosedOnAWorkdayEvening_thenItShouldOpenTomorrow() {
        assertThat(WEEKDAYS_ONLY_10_TO_20.statusFor(2024, 3, 11, 21, 0))
            .isEqualTo("Opens tomorrow at 10:00");
        assertThat(WEEKDAYS_ONLY_930_TO_1730.statusFor(2024, 3, 11, 18, 0))
            .isEqualTo("Opens tomorrow at 09:30");
    }

    @Test
    void whenShopIsOpen_thenItShouldCloseInTheEvening() {
        assertThat(WEEKDAYS_ONLY_10_TO_20.statusFor(2024, 3, 11, 15, 0))
            .isEqualTo("Closes at 20:00");
        assertThat(WEEKDAYS_ONLY_930_TO_1730.statusFor(2024, 3, 11, 15, 0))
            .isEqualTo("Closes at 17:30");
    }

    @Test
    void whenShopIsClosedOnFridayEvening_thenItShouldOpenOnMonday() {
        assertThat(WEEKDAYS_ONLY_10_TO_20.statusFor(2024, 3, 15, 21, 0))
            .isEqualTo("Opens on Monday at 10:00");
        assertThat(WEEKDAYS_ONLY_930_TO_1730.statusFor(2024, 3, 15, 18, 0))
            .isEqualTo("Opens on Monday at 09:30");
    }
}