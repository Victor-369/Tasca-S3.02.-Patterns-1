package com.nivell3.strategy.strategies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlStrategyTest {
    @Test
    void generateReport_returnXmlFormatWithData_getsDataFormatted() {
        XmlStrategy xmlStrategy = new XmlStrategy();

        String data = "Example of data";
        String dataFormatted = xmlStrategy.generateReport(data);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<information><customer><data>Example of data</data></customer></information>";

        assertThat(dataFormatted).isEqualTo(expected);
    }
}
