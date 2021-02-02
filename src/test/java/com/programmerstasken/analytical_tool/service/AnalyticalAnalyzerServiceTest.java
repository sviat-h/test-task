package com.programmerstasken.analytical_tool.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalyticalAnalyzerServiceTest {
    AnalyticalAnalyzerService analyzerService = new AnalyticalAnalyzerService();

    @Test
    void getAnalysis() {
        List<String> timeLines = List.of("C 1.1 8.15.1 P 15.10.2012 83", "C 1 10.1 P 01.12.2012 65",
                "C 1.1 5.5.1 P 01.11.2012 117", "C 3 10.2 N 02.10.2012 100");
        List<String> queries = List.of("D 1.1 8 P 01.01.2012-01.12.2012", "D 1 * P 08.10.2012-20.11.2012",
                "D 3 10 P 01.12.2012");

        String[] expectedAnalysis = {"83", "100", "-"};
        String[] actualAnalysis = analyzerService.getAnalysis(timeLines, queries);

        for (int i = 0; i < expectedAnalysis.length; i++) {
            assertEquals(expectedAnalysis[i], actualAnalysis[i]);
        }
    }
}