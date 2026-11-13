package com.nivell3.strategy.strategies;

import com.nivell3.strategy.interfaces.ReportStrategy;

public class WordStrategy implements ReportStrategy {
    @Override
    public String generateReport(String data) {
        checkData(data);

        return "Word: " + data;
    }

    private void checkData(String data) {
        if (data == null || data.isBlank()) throw new IllegalArgumentException("Data must be filled");
    }
}
