package com.nivell3.strategy.strategies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExcelStrategyTest {
    @Test
    void generateReport_returnExcelFormatWithData_getsDataFormatted() {
        ExcelStrategy excelStrategy = new ExcelStrategy();

        String data = "Example of data";
        String dataFormatted = excelStrategy.generateReport(data);
        String expected = "Excel: Example of data";

        assertThat(dataFormatted).isEqualTo(expected);
    }
}
