package com.nivell2.abstractfactory.products;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SpainPhoneTest {
    @Test
    void getPhoneNumber_getSpainPhone_showsSpainPhone() {
        SpainPhone spainPhone = new SpainPhone("687543987");

        String phone = spainPhone.getPhoneNumber();
        String expectedPhone = "+34 687 54 39 87";

        assertThat(phone).isEqualTo(expectedPhone);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "687543",
            "6875a6543",
            "90687543z",
            "1234567890"
    })
    void constructor_whenPhoneNumberIsWrong_throwsIllegalArgumentException(String spainPhoneNumber) {
        assertThatThrownBy(() -> new SpainPhone(spainPhoneNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Phone number has wrong format for Spain country");
    }
}
