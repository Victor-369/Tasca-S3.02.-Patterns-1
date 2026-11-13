package com.nivell3.strategy.strategies;

import com.nivell3.strategy.interfaces.ReportStrategy;

public class ExcelStrategy implements ReportStrategy {
    @Override
    public String generateReport(String data) {
        return "Excel: " + data;
    }
}
