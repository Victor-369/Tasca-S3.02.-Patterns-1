package com.nivell2.abstractfactory.products;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SpainAddressTest {
    @Test
    void getAddress_getSpanishAddress_showsSpainAddress() {
        SpainAddress spainAddress = new SpainAddress("Carrer Major 34", "Barcelona",
                "08001");

        String address = spainAddress.getAddress();
        String expectedAddress = "Carrer Major 34, 08001 Barcelona";

        assertThat(address).isEqualTo(expectedAddress);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "687543",
            "9743",
            "9874z",
            "98a43"
    })
    void constructor_insertWrongPostalCodeInSpainAddress_showsException(String postalCode) {
        assertThatThrownBy(() -> new SpainAddress("Carrer Major 34", "Barcelona",
                postalCode))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Postal code must be a valid number");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "     "
    })
    void constructor_insertBlankStreetNameInSpainAddress_showsException(String streetName) {
        assertThatThrownBy(() -> new SpainAddress(streetName, "Barcelona",
                "08001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Street must be filled");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "     "
    })
    void constructor_insertBlankCityInSpainAddress_showsException(String city) {
        assertThatThrownBy(() -> new SpainAddress("Carrer Major 34", city,
                "08001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("City must be filled");
    }
}
