package com.nivell2.abstractfactory.products;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class USAAddressTest {
    @Test
    void getAddress_getUSAAddress_showsUSAAddress() {
        USAAddress usaAddress = new USAAddress("154 5th Avenue", "New York", "NY 10001");

        String address = usaAddress.getAddress();
        String expectedAddress = "154 5th Avenue, New York, NY 10001";

        assertThat(address).isEqualTo(expectedAddress);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "ny 10001",
            "10001",
            "00 10001",
            "NY 10s01",
            "     "
    })
    void constructor_insertWrongPostalCodeInUSAAddress_showsException(String postalCode) {
        assertThatThrownBy(() -> new USAAddress("154 5th Avenue", "New York", postalCode))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Must be a 2-letter state code followed by a 5-digit ZIP");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "     "
    })
    void constructor_insertBlankStreetNameInUSAAddress_showsException(String streetName) {
        assertThatThrownBy(() -> new USAAddress(streetName, "New York", "NY 10001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Street must be filled");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "     "
    })
    void constructor_insertBlankCityInUSAAddress_showsException(String city) {
        assertThatThrownBy(() -> new USAAddress("154 5th Avenue", city, "NY 10001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("City must be filled");
    }
}
