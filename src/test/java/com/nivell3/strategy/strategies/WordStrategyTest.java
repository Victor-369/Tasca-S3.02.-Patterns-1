package com.nivell3.strategy.strategies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordStrategyTest {
    @Test
    void generateReport_returnWordFormatWithData_getsDataFormatted() {
        WordStrategy wordStrategy = new WordStrategy();

        String data = "Example of data";
        String dataFormatted = wordStrategy.generateReport(data);
        String expected = "Word: Example of data";

        assertThat(dataFormatted).isEqualTo(expected);
    }
}
