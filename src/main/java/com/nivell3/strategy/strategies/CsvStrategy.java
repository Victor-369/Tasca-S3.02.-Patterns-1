package com.nivell3.strategy.strategies;

import com.nivell3.strategy.interfaces.ReportStrategy;

public class CsvStrategy implements ReportStrategy {
    @Override
    public String generateReport(String data) {
        return "name;price;" + data;
    }
}
