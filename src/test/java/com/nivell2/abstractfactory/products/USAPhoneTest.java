package com.nivell2.abstractfactory.products;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class USAPhoneTest {
    @Test
    void getPhoneNumber_getUSAPhone_showsUSAPhone() {
        USAPhone usaPhone = new USAPhone("687543987");

        String phone = usaPhone.getPhoneNumber();
        String expectedPhone = "+1 (068) 754-3987";

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
    void constructor_whenPhoneNumberIsWrong_throwsIllegalArgumentException(String usaPhoneNumber) {
        assertThatThrownBy(() -> new USAPhone(usaPhoneNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Phone number has wrong format for USA country");
    }
}
