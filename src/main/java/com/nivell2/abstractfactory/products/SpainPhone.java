package com.nivell2.abstractfactory.products;

import com.nivell2.abstractfactory.interfaces.Phone;

public class SpainPhone implements Phone {
    private final String phoneNumber;
    private static final String PHONE_REGEX_ES = "^\\d{9}$";
    private static final String PREFIX = "+34";

    public SpainPhone(String phoneNumber) {
        this.phoneNumber = checkPhoneNumber(phoneNumber);
    }

    @Override
    public String getPhoneNumber() {
        String blockOne = phoneNumber.substring(0, 3);
        String blockTwo = phoneNumber.substring(3, 5);
        String blockThree = phoneNumber.substring(5, 7);
        String blockFour = phoneNumber.substring(7, 9);

        return PREFIX + " " + blockOne + " " + blockTwo + " " + blockThree + " " + blockFour;
    }

    private String checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches(PHONE_REGEX_ES)) {
            throw new IllegalArgumentException("Phone number has wrong format for Spain country");
        }

        return phoneNumber;
    }
}
