package com.nivell2.abstractfactory.products;

import com.nivell2.abstractfactory.interfaces.Address;

public class USAAddress implements Address {
    private final String street;
    private final String city;
    private final String postalCode;
    private static final String ZIP_REGEX_US = "^[A-Z]{2}\\s\\d{5}$";

    public USAAddress(String street, String city, String postalCode) {
        this.street = checkText(street, "Street");
        this.city = checkText(city, "City");
        this.postalCode = checkPostalCode(postalCode);
    }

    private String checkText(String text, String attribute) {
        if (text == null || text.isBlank()) throw new IllegalArgumentException(attribute + " must be filled");

        return text;
    }

    private String checkPostalCode(String postalCode) {
        if (postalCode == null ||
                !postalCode.matches(ZIP_REGEX_US)) throw new IllegalArgumentException("Must be a 2-letter state code followed by a 5-digit ZIP");

        return postalCode;
    }

    @Override
    public String getAddress() {
        return street + ", " + city + ", " + postalCode;
    }
}
