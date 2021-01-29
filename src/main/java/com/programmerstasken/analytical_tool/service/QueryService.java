package com.programmerstasken.analytical_tool.service;

import com.programmerstasken.analytical_tool.entity.Query;
import com.programmerstasken.analytical_tool.utils.RequestValidator;
import com.programmerstasken.analytical_tool.utils.Symbol;

import java.util.ArrayList;
import java.util.List;

public class QueryService {

    private static QueryService instance;

    private QueryService() {
    }

    public static QueryService getInstance() {
        if (instance == null) {
            instance = new QueryService();
        }
        return instance;
    }

    RequestValidator requestValidator = new RequestValidator();
    List<Query> queryList = new ArrayList<>();

    public void processQueries(List<String> queries) {

        for (String queryString : queries) {
            Query query = new Query();
            String[] splitQuery = queryString.split(Symbol.SPACE.toString());

            int requiredNumberOfQueryParameters = 5;
            if (splitQuery.length != requiredNumberOfQueryParameters) {
                throw new IllegalArgumentException("Invalid request!");
            } else {

                int indexOfServiceNumber = 1;
                String serviceNumber = splitQuery[indexOfServiceNumber];
                requestValidator.validateAndSaveServiceNumber(query, serviceNumber);

                int indexOfQuestionType = 2;
                String questionType = splitQuery[indexOfQuestionType];
                requestValidator.validateAndSaveQuestionType(query, questionType);

                int indexOfResponseType = 3;
                String responseType = splitQuery[indexOfResponseType];
                requestValidator.validateAndSaveResponseType(query, responseType);

                int indexOfDateFrom = 4;
                String dateFromAndDateTo = splitQuery[indexOfDateFrom];
                requestValidator.validateAndSaveDateFromAndDateTo(query, dateFromAndDateTo);

                queryList.add(query);
            }
        }
    }

    public List<Query> getQueryList() {
        return queryList;
    }
}
