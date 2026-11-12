package com.nivell2.abstractfactory.factories;

import com.nivell2.abstractfactory.interfaces.Address;
import com.nivell2.abstractfactory.interfaces.ContactFactory;
import com.nivell2.abstractfactory.interfaces.Phone;
import com.nivell2.abstractfactory.products.SpainAddress;
import com.nivell2.abstractfactory.products.SpainPhone;

public class SpainContactFactory implements ContactFactory {
    private final String street;
    private final String city;
    private final String postalCode;
    private final String phoneNumber;

    public SpainContactFactory(String street, String city, String postalCode, String phoneNumber) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Address createAddress() {
        return new SpainAddress(street, city, postalCode);
    }

    @Override
    public Phone createPhone() {
        return new SpainPhone(phoneNumber);
    }
}
