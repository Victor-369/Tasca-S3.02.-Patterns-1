package com.nivell3.strategy.strategies;

import com.nivell3.strategy.interfaces.ReportStrategy;

public class XmlStrategy implements ReportStrategy {
    @Override
    public String generateReport(String data) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<information>" +
                "<customer>" +
                "<data>" + data + "</data>" +
                "</customer>" +
                "</information>";
    }
}
