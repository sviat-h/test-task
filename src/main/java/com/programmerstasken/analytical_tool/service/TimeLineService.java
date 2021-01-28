package com.programmerstasken.analytical_tool.service;

import com.programmerstasken.analytical_tool.entity.TimeLine;
import com.programmerstasken.analytical_tool.utils.Symbol;
import com.programmerstasken.analytical_tool.utils.TimeLineValidator;

import java.util.ArrayList;
import java.util.List;

public class TimeLineService {

    TimeLineValidator timeLineValidator = new TimeLineValidator();
    List<TimeLine> timeLinesList = new ArrayList<>();

    public void processTimeLines(List<String> timeLinesString) {
        for (String timeLineString : timeLinesString) {
            TimeLine timeLine = new TimeLine();
            String[] splitTimeLine = timeLineString.split(Symbol.SPACE.toString());

            int requiredNumberOfQueryParameters = 6;
            if (splitTimeLine.length != requiredNumberOfQueryParameters) {
                throw new IllegalArgumentException("Invalid request!");
            } else {

                int indexOfServiceNumber = 1;
                String serviceNumber = splitTimeLine[indexOfServiceNumber];
                timeLineValidator.validateAndSaveServiceNumber(timeLine, serviceNumber);

                int indexOfQuestionType = 2;
                String questionType = splitTimeLine[indexOfQuestionType];
                timeLineValidator.validateAndSaveQuestionType(timeLine, questionType);

                int indexOfResponseType = 3;
                String responseType = splitTimeLine[indexOfResponseType];
                timeLineValidator.validateAndSaveResponseType(timeLine, responseType);

                int indexOfDate = 4;
                String date = splitTimeLine[indexOfDate];
                timeLineValidator.validateAndSaveDate(timeLine, date);

                int indexOfTime = 5;
                String time = splitTimeLine[indexOfTime];
                timeLineValidator.validateAndSaveTime(timeLine, time);

                timeLinesList.add(timeLine);
            }
        }
    }

    public List<TimeLine> getTimeLinesList() {
        return timeLinesList;
    }
}
