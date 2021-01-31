package com.programmerstasken.analytical_tool.service;

import com.programmerstasken.analytical_tool.entity.TimeLine;
import com.programmerstasken.analytical_tool.utils.RequestValidator;
import com.programmerstasken.analytical_tool.utils.Symbol;

import java.util.ArrayList;
import java.util.List;

public class TimeLineService {

    private static TimeLineService instance;

    private TimeLineService() {
    }

    public static TimeLineService getInstance() {
        if (instance == null) {
            instance = new TimeLineService();
        }
        return instance;
    }

    RequestValidator requestValidator = new RequestValidator();
    List<TimeLine> timeLinesList = new ArrayList<>();

    public List<TimeLine> processTimeLines(List<String> timeLinesString) {
        for (String timeLineString : timeLinesString) {
            TimeLine timeLine = new TimeLine();
            String[] splitTimeLine = timeLineString.split(Symbol.SPACE.toString());

            int requiredNumberOfQueryParameters = 6;
            if (splitTimeLine.length != requiredNumberOfQueryParameters) {
                throw new IllegalArgumentException("Invalid request!");
            } else {

                int indexOfServiceNumber = 1;
                String serviceNumber = splitTimeLine[indexOfServiceNumber];
                requestValidator.validateAndSaveServiceNumber(timeLine, serviceNumber);

                int indexOfQuestionType = 2;
                String questionType = splitTimeLine[indexOfQuestionType];
                requestValidator.validateAndSaveQuestionType(timeLine, questionType);

                int indexOfResponseType = 3;
                String responseType = splitTimeLine[indexOfResponseType];
                requestValidator.validateAndSaveResponseType(timeLine, responseType);

                int indexOfDate = 4;
                String date = splitTimeLine[indexOfDate];
                requestValidator.validateAndSaveDate(timeLine, date);

                int indexOfTime = 5;
                String time = splitTimeLine[indexOfTime];
                requestValidator.validateAndSaveTime(timeLine, time);

                timeLinesList.add(timeLine);
            }
        }
        return timeLinesList;
    }
}
