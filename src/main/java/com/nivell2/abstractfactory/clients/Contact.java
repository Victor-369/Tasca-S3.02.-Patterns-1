package com.nivell2.abstractfactory.clients;

import com.nivell2.abstractfactory.interfaces.Address;
import com.nivell2.abstractfactory.interfaces.ContactFactory;
import com.nivell2.abstractfactory.interfaces.Phone;

public class Contact {
    private final Address address;
    private final Phone phone;

    public Contact(ContactFactory contactFactory) {
        this.address = contactFactory.createAddress();
        this.phone = contactFactory.createPhone();
    }

    @Override
    public String toString() {
        return "Address: " + address.getAddress() + " | Phone: " + phone.getPhoneNumber();
    }
}
