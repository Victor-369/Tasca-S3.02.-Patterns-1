package com.nivell3.strategy.strategies;

import com.nivell3.strategy.interfaces.ReportStrategy;

public class XmlStrategy implements ReportStrategy {
    @Override
    public String generateReport(String data) {
        checkData(data);

        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<information> " +
                "<data>" + data +
                "</data>";
    }

    private void checkData(String data) {
        if (data == null || data.isBlank()) throw new IllegalArgumentException("Data must be filled");
    }
}
