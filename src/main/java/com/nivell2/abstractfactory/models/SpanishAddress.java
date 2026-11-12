package com.nivell2.abstractfactory.models;

import com.nivell2.abstractfactory.interfaces.Address;

public class SpanishAddress implements Address {
    private final String street;
    private final int streetNumber;
    private final String city;
    private final String postalCode;

    public SpanishAddress(String street, int streetNumber, String city, String postalCode) {
        this.street = checkText(street, "Street");
        this.streetNumber = checkStreetNumber(streetNumber);
        this.city = checkText(city, "City");
        this.postalCode = checkPostalCode(postalCode);
    }

    private String checkText(String text, String attribute) {
        if (text == null || text.isEmpty()) throw new IllegalArgumentException(attribute + " must be filled");

        return text;
    }

    private int checkStreetNumber(int streetNumber) {
        if (streetNumber < 1) throw new IllegalArgumentException("Street number must be positive");

        return streetNumber;
    }

    private String checkPostalCode(String postalCode) {
        if (postalCode == null ||
                postalCode.isEmpty() ||
                !postalCode.matches("\\d{5}")) throw new IllegalArgumentException("Postal code must be a valid number");

        return postalCode;
    }

    @Override
    public String getAddress() {
        return street + " " + streetNumber + ", " + postalCode + " " + city;
    }
}
