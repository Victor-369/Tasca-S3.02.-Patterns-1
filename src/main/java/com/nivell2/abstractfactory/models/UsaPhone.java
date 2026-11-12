package com.nivell2.abstractfactory.models;

import com.nivell2.abstractfactory.interfaces.Phone;

public abstract class UsaPhone implements Phone {
    private final String phoneNumber;
    private static final String PHONE_REGEX_US = "^\\+1\\s\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";

    protected UsaPhone(String phoneNumber) {
        this.phoneNumber = checkPhoneNumber(phoneNumber);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches(PHONE_REGEX_US)) {
            throw new IllegalArgumentException("Phone number has wrong format for USA country");
        }

        return phoneNumber;
    }
}
