package com.nivell2.abstractfactory.models;

import com.nivell2.abstractfactory.interfaces.Phone;

public class SpanishPhone implements Phone {
    private final String phoneNumber;
    private static final String PHONE_REGEX_ES = "^\\+34\\s\\d{9}$";

    public SpanishPhone(String phoneNumber) {
        this.phoneNumber = checkPhoneNumber(phoneNumber);
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches(PHONE_REGEX_ES)) {
            throw new IllegalArgumentException("Phone number has wrong format for Spain country");
        }

        return phoneNumber;
    }
}
