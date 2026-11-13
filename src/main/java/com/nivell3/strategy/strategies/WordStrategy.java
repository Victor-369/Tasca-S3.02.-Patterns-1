package com.nivell3.strategy.strategies;

import com.nivell3.strategy.interfaces.ReportStrategy;

public class WordStrategy implements ReportStrategy {
    @Override
    public String generateReport(String data) {
        return "Word: " + data;
    }
}
