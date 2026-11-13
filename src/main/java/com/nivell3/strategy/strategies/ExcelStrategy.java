package com.nivell3.strategy.strategies;

import com.nivell3.strategy.interfaces.ReportStrategy;

public class ExcelStrategy implements ReportStrategy {
    @Override
    public String generateReport(String data) {
        checkData(data);

        return "Excel: " + data;
    }

    private void checkData(String data) {
        if (data == null || data.isBlank()) throw new IllegalArgumentException("Data must be filled");
    }
}
