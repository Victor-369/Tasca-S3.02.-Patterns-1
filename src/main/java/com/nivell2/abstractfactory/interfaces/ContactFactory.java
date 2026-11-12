package com.nivell2.abstractfactory.interfaces;

public interface ContactFactory {
    public Address createAddress();
    public Phone createPhone();
}
