package com.nivell3.strategy.services;

import com.nivell3.strategy.interfaces.ReportStrategy;

public class ReportService {
    private ReportStrategy reportStrategy;

    public ReportService(ReportStrategy reportStrategy) {
        this.reportStrategy = checkReportStrategy(reportStrategy);
    }

    public String getReport(String data) {
        return this.reportStrategy.generateReport(data);
    }

    public void setReportStrategy(ReportStrategy newReportStrategy) {
        this.reportStrategy = checkReportStrategy(newReportStrategy);
    }

    private ReportStrategy checkReportStrategy(ReportStrategy reportStrategy) {
        if (reportStrategy == null) throw new IllegalArgumentException("Need a report strategy");

        return reportStrategy;
    }
}
