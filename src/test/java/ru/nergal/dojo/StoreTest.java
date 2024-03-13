package ru.nergal.dojo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StoreTest {
    @Test
    void shouldInstantiate() {
        Store actual =  new Store();
        assertThat(actual).isNotNull();
    }
}