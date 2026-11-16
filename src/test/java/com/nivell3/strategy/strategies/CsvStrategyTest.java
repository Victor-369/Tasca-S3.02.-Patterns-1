package com.nivell3.strategy.strategies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvStrategyTest {
    @Test
    void generateReport_returnCsvFormatWithData_getsDataFormatted() {
        CsvStrategy csvStrategy = new CsvStrategy();

        String data = "Example of data";
        String dataFormatted = csvStrategy.generateReport(data);
        String expected = "name;price;Example of data";

        assertThat(dataFormatted).isEqualTo(expected);
    }
}
