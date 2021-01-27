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

    public static class Builder {
        private Query newQuery;

        public Builder() {
            newQuery = new Query();
        }

        public Builder withServiceNumber(int serviceNumber) {
            newQuery.serviceNumber = serviceNumber;
            return this;
        }

        public Builder withServiceVariation(int serviceVariation) {
            newQuery.serviceVariation = serviceVariation;
            return this;
        }

        public Builder withQuestionType(int questionType) {
            newQuery.questionType = questionType;
            return this;
        }

        public Builder withQuestionCategory(int questionCategory) {
            newQuery.questionCategory = questionCategory;
            return this;
        }

        public Builder withQuestionSubcategory(int questionSubcategory) {
            newQuery.questionSubcategory = questionSubcategory;
            return this;
        }

        public Builder withResponseType(String responseType) {
            newQuery.responseType = responseType;
            return this;
        }

        public Builder withDateFrom(LocalDate dateFrom) {
            newQuery.dateFrom = dateFrom;
            return this;
        }

        public Builder withDateTo(LocalDate dateTo) {
            newQuery.dateTo = dateTo;
            return this;
        }

        public Query build() {
            return newQuery;
        }
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public int getServiceVariation() {
        return serviceVariation;
    }

    public int getQuestionType() {
        return questionType;
    }

    public int getQuestionCategory() {
        return questionCategory;
    }

    public int getQuestionSubcategory() {
        return questionSubcategory;
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
