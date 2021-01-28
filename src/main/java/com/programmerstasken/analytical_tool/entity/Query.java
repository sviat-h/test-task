package com.programmerstasken.analytical_tool.entity;

import java.time.LocalDate;

public class Query {

    private int serviceNumber;
    private int serviceVariation;

    private int questionType;
    private int questionCategory;
    private int questionSubcategory;

    private String responseType;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public int getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public int getServiceVariation() {
        return serviceVariation;
    }

    public void setServiceVariation(int serviceVariation) {
        this.serviceVariation = serviceVariation;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public int getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(int questionCategory) {
        this.questionCategory = questionCategory;
    }

    public int getQuestionSubcategory() {
        return questionSubcategory;
    }

    public void setQuestionSubcategory(int questionSubcategory) {
        this.questionSubcategory = questionSubcategory;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }
}
