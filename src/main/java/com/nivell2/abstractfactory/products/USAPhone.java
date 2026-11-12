package com.nivell2.abstractfactory.products;

import com.nivell2.abstractfactory.interfaces.Phone;

public class USAPhone implements Phone {
    private final String phoneNumber;
    private static final String PHONE_REGEX_US = "^\\d{9}$";
    private static final String PREFIX = "+1";

    public USAPhone(String phoneNumber) {
        this.phoneNumber = checkPhoneNumber(phoneNumber);
    }

    @Override
    public String getPhoneNumber() {
        String formattedPhoneNumber = phoneNumber.replaceFirst(
                "(\\d{2})(\\d{3})(\\d{4})",
                "($1) $2-$3"
        );

        formattedPhoneNumber = formattedPhoneNumber.replace("(", "(0");

        return PREFIX + " " + formattedPhoneNumber;
    }

    private String checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches(PHONE_REGEX_US)) {
            throw new IllegalArgumentException("Phone number has wrong format for USA country");
        }

        return phoneNumber;
    }
}
