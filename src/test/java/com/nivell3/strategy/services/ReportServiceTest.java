package com.nivell3.strategy.services;

import com.nivell3.strategy.interfaces.ReportStrategy;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReportServiceTest {
    @Test
    void generateReport_givenStrategy_callsStrategyWithSameData() {
        String dataExample = "Data example";
        ReportStrategy strategy = mock(ReportStrategy.class);

        ReportService reportService = new ReportService(strategy);
        reportService.generateReport(dataExample);

        verify(strategy).generateReport(dataExample);
    }
}
