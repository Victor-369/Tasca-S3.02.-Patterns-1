package com.nivell3.strategy.strategies;

import com.nivell3.strategy.interfaces.ReportStrategy;

public class HtmlStrategy implements ReportStrategy {
    @Override
    public String generateReport(String data) {
        return "<HTML> " + data + " </HTML>";
    }
}
