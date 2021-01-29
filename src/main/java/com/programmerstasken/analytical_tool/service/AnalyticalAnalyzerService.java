package com.programmerstasken.analytical_tool.service;

import com.programmerstasken.analytical_tool.entity.Query;
import com.programmerstasken.analytical_tool.entity.TimeLine;

import java.util.List;

public class AnalyticalAnalyzerService {

    //TODO implement the class

    QueryService queryService = QueryService.getInstance();
    TimeLineService timeLineService = TimeLineService.getInstance();

    public String getAnalysis() {

        List<TimeLine> timeLinesList = timeLineService.getTimeLinesList();
        List<Query> queryList = queryService.getQueryList();

        return null;
    }
}
