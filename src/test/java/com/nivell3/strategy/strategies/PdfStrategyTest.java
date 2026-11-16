package com.nivell3.strategy.strategies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PdfStrategyTest {
    @Test
    void generateReport_returnPdfFormatWithData_getsDataFormatted() {
        PdfStrategy pdfStrategy = new PdfStrategy();

        String data = "Example of data";
        String dataFormatted = pdfStrategy.generateReport(data);
        String expected = "PDF: Example of data";

        assertThat(dataFormatted).isEqualTo(expected);
    }
}
