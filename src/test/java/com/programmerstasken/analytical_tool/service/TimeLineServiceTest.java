package com.programmerstasken.analytical_tool.service;

import com.programmerstasken.analytical_tool.entity.TimeLine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeLineServiceTest {

    TimeLineService timeLineService = TimeLineService.getInstance();
    static List<TimeLine> actualTimeLines = new ArrayList<>();
    static List<TimeLine> expectedTimeLines;

    @BeforeAll
    static void setUp() {
        TimeLine timeLine1 = new TimeLine();
        TimeLine timeLine2 = new TimeLine();

        timeLine1.setServiceNumber(1);
        timeLine1.setServiceVariation(1);
        timeLine1.setQuestionType(8);
        timeLine1.setQuestionCategory(15);
        timeLine1.setQuestionSubcategory(1);
        timeLine1.setResponseType("P");
        timeLine1.setDate(LocalDate.of(2012, 10, 15));
        timeLine1.setTime(83);

        timeLine2.setServiceNumber(1);
        timeLine2.setServiceVariation(0);
        timeLine2.setQuestionType(10);
        timeLine2.setQuestionCategory(1);
        timeLine2.setQuestionSubcategory(0);
        timeLine2.setResponseType("P");
        timeLine2.setDate(LocalDate.of(2012, 12, 1));
        timeLine2.setTime(65);

        actualTimeLines.add(timeLine1);
        actualTimeLines.add(timeLine2);
        actualTimeLines.add(timeLine1);
    }

    @Test
    void processTimeLines() {
        List<String> timeLinesString = new ArrayList<>();
        timeLinesString.add("C 1.1 8.15.1 P 15.10.2012 83");
        timeLinesString.add("C 1 10.1 P 01.12.2012 65");
        timeLinesString.add("C 1.1 8.15.1 P 15.10.2012 83");

        expectedTimeLines = timeLineService.processTimeLines(timeLinesString);

        for (int i = 0; i < actualTimeLines.size(); i++) {
            assertEquals(expectedTimeLines.get(i), actualTimeLines.get(i));
        }
    }
}