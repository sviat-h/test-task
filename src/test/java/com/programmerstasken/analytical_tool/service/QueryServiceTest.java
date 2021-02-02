package com.programmerstasken.analytical_tool.service;

import com.programmerstasken.analytical_tool.entity.Query;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryServiceTest {
    QueryService queryService = QueryService.getInstance();
    static List<Query> actualQueries = new ArrayList<>();
    static List<Query> expectedQueries;

    @BeforeAll
    static void setUp() {
        Query query1 = new Query();
        Query query2 = new Query();

        query1.setServiceNumber(1);
        query1.setServiceVariation(1);
        query1.setQuestionType(8);
        query1.setQuestionCategory(0);
        query1.setQuestionSubcategory(0);
        query1.setResponseType("P");
        query1.setDateFrom(LocalDate.of(2012, 1, 1));
        query1.setDateTo(LocalDate.of(2012, 12, 1));

        query2.setServiceNumber(1);
        query2.setServiceVariation(0);
        query2.setQuestionType(0);
        query2.setQuestionCategory(0);
        query2.setQuestionSubcategory(0);
        query2.setResponseType("P");
        query2.setDateFrom(LocalDate.of(2012, 10, 8));
        query2.setDateTo(LocalDate.of(2012, 11, 20));

        actualQueries.add(query1);
        actualQueries.add(query2);
        actualQueries.add(query1);
    }

    @Test
    void processQueries() {
        List<String> queriesString = new ArrayList<>();
        queriesString.add("D 1.1 8 P 01.01.2012-01.12.2012");
        queriesString.add("D 1 * P 08.10.2012-20.11.2012");
        queriesString.add("D 1.1 8 P 01.01.2012-01.12.2012");

        expectedQueries = queryService.processQueries(queriesString);

        for (int i = 0; i < actualQueries.size(); i++) {
            assertEquals(expectedQueries.get(i), actualQueries.get(i));
        }
    }
}