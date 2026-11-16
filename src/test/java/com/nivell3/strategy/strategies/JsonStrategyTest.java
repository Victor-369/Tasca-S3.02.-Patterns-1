package com.nivell3.strategy.strategies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonStrategyTest {
    @Test
    void generateReport_returnJsonFormatWithData_getsDataFormatted() {
        JsonStrategy jsonStrategy = new JsonStrategy();

        String data = "Example of data";
        String dataFormatted = jsonStrategy.generateReport(data);
        String expected = "{ Example of data }";

        assertThat(dataFormatted).isEqualTo(expected);
    }
}
