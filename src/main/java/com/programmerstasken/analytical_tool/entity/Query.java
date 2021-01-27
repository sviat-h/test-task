package com.programmerstasken.analytical_tool.entity;

import java.time.LocalDate;

public class Query {

    private String serviceNumber;
    private String questionType;
    private String responseType;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Query(String serviceNumber, String questionType, String responseType, LocalDate dateFrom, LocalDate dateTo) {
        this.serviceNumber = serviceNumber;
        this.questionType = questionType;
        this.responseType = responseType;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Query(String serviceNumber, String questionType, String responseType, LocalDate dateFrom) {
        this.serviceNumber = serviceNumber;
        this.questionType = questionType;
        this.responseType = responseType;
        this.dateFrom = dateFrom;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getResponseType() {
        return responseType;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }
}
