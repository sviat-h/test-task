package com.programmerstasken.analytical_tool.service;

import com.programmerstasken.analytical_tool.entity.Query;
import com.programmerstasken.analytical_tool.entity.TimeLine;
import com.programmerstasken.analytical_tool.utils.Symbol;

import java.util.List;

public class AnalyticalAnalyzerService {

    QueryService queryService = QueryService.getInstance();
    TimeLineService timeLineService = TimeLineService.getInstance();

    public String[] getAnalysis(List<String> timeLines, List<String> queries) {
        List<TimeLine> timeLinesList = timeLineService.processTimeLines(timeLines);
        List<Query> queryList = queryService.processQueries(queries);

        return getAverageWaitingTime(timeLinesList, queryList);
    }

    private String[] getAverageWaitingTime(List<TimeLine> timeLinesList, List<Query> queryList) {
        int responseSize = queryList.size();
        String[] response = new String[responseSize];

        for (int i = 0; i < responseSize; i++) {
            Query query = queryList.get(i);
            int totalTime = 0;
            int countMatches = 0;

            for (TimeLine timeLine : timeLinesList) {
                if (matchService(query, timeLine) &&
                        matchQuestion(query, timeLine) &&
                        matchResponse(query, timeLine) &&
                        matchDate(query, timeLine)
                ) {
                    totalTime += timeLine.getTime();
                    countMatches++;
                }
            }
            if (countMatches == 0) {
                response[i] = Symbol.HYPHEN.toString();
            } else {
                response[i] = String.valueOf(totalTime / countMatches);
            }
        }
        return response;
    }

    //0 means query match all  services/question types
    private boolean matchService(Query query, TimeLine timeLine) {
        return (query.getServiceNumber() == 0 || timeLine.getServiceNumber() == query.getServiceNumber()) &&
                (query.getServiceVariation() == 0 || timeLine.getServiceVariation() == query.getServiceVariation());
    }

    //0 means query match all  services/question types
    private boolean matchQuestion(Query query, TimeLine timeLine) {
        return (query.getQuestionType() == 0 || timeLine.getQuestionType() == query.getQuestionType()) &&
                (query.getQuestionCategory() == 0 || timeLine.getQuestionCategory() == query.getQuestionCategory()) &&
                (query.getQuestionSubcategory() == 0 || timeLine.getQuestionSubcategory() == query.getQuestionSubcategory());
    }

    private boolean matchResponse(Query query, TimeLine timeLine) {
        return query.getResponseType().equals(timeLine.getResponseType());
    }

    private boolean matchDate(Query query, TimeLine timeLine) {
        if (query.getDateTo() == null) {
            return query.getDateFrom().equals(timeLine.getDate());
        } else {
            return query.getDateFrom().isBefore(timeLine.getDate()) && query.getDateTo().isAfter(timeLine.getDate());
        }
    }
}
