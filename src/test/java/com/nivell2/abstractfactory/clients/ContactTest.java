package com.nivell2.abstractfactory.clients;

import com.nivell2.abstractfactory.factories.SpainContactFactory;
import com.nivell2.abstractfactory.factories.USAContactFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactTest {
    @Test
    void toString_withSpainDataContact_showDataContact() {
        Contact spainContact = new Contact(new SpainContactFactory("Carrer Major 34", "Barcelona",
                "08001", "623456789"));

        String message = spainContact.toString();
        String expected = "Address: Carrer Major 34, 08001 Barcelona | Phone: +34 623 45 67 89";

        assertThat(message).isEqualTo(expected);
    }

    @Test
    void toString_withUSADataContact_showDataContact() {
        Contact usaContact = new Contact(new USAContactFactory("154 5th Avenue", "New York",
                "NY 10001", "987654321"));

        String message = usaContact.toString();
        String expected = "Address: 154 5th Avenue, New York, NY 10001 | Phone: +1 (098) 765-4321";

        assertThat(message).isEqualTo(expected);
    }
}
