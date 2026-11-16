package com.nivell3.strategy.strategies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HtmlStrategyTest {
    @Test
    void generateReport_returnHtmlFormatWithData_getsDataFormatted() {
        HtmlStrategy htmlStrategy = new HtmlStrategy();

        String data = "Example of data";
        String dataFormatted = htmlStrategy.generateReport(data);
        String expected = "<HTML> Example of data </HTML>";

        assertThat(dataFormatted).isEqualTo(expected);
    }
}
