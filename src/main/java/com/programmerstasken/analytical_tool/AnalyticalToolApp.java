package com.programmerstasken.analytical_tool;

import com.programmerstasken.analytical_tool.service.AnalyticalAnalyzerService;
import com.programmerstasken.analytical_tool.service.QueryService;
import com.programmerstasken.analytical_tool.service.TimeLineService;
import com.programmerstasken.analytical_tool.utils.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnalyticalToolApp {
    public static void main(String[] args) {
        QueryService queryService = new QueryService();
        TimeLineService timeLineService = new TimeLineService();
        AnalyticalAnalyzerService analyzerService = new AnalyticalAnalyzerService();

        Scanner scanner = new Scanner(System.in);
        int countOfLines = Integer.parseInt(scanner.nextLine());
        List<String> queries = new ArrayList<>();
        List<String> timeLines = new ArrayList<>();

        for (int i = 0; i < countOfLines; i++) {
            String line = scanner.nextLine();

            if (line.startsWith(Symbol.D.toString())) {
                queries.add(line);
            } else if (line.startsWith(Symbol.C.toString())) {
                timeLines.add(line);
            } else {
                throw new IllegalArgumentException("Line must start with C or D symbol");
            }
        }
        scanner.close();

        timeLineService.processTimeLines(timeLines);
        queryService.processQueries(queries);
        analyzerService.getAnalysis();
    }
}
