package com.nivell3.strategy.strategies;

import com.nivell3.strategy.interfaces.ReportStrategy;

public class PdfStrategy implements ReportStrategy {
    @Override
    public String generateReport(String data) {
        return "PDF: " + data;
    }
}
