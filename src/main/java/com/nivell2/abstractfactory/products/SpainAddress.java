package com.nivell2.abstractfactory.products;

import com.nivell2.abstractfactory.interfaces.Address;

public class SpanishAddress implements Address {
    private final String street;
    private final String city;
    private final String postalCode;

    public SpanishAddress(String street, String city, String postalCode) {
        this.street = checkText(street, "Street");
        this.city = checkText(city, "City");
        this.postalCode = checkPostalCode(postalCode);
    }

    private String checkText(String text, String attribute) {
        if (text == null || text.isEmpty()) throw new IllegalArgumentException(attribute + " must be filled");

        return text;
    }

    private String checkPostalCode(String postalCode) {
        if (postalCode == null ||
                !postalCode.matches("\\d{5}")) throw new IllegalArgumentException("Postal code must be a valid number");

        return postalCode;
    }

    @Override
    public String getAddress() {
        return street + ", " + postalCode + " " + city;
    }
}
