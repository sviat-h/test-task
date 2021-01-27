package com.programmerstasken.analytical_tool.entity;

import java.time.LocalDate;

public class TimeLine {

    private int serviceNumber;
    private int serviceVariation;

    private int questionType;
    private int questionCategory;
    private int questionSubcategory;

    private String responseType;
    private LocalDate date;
    private int time;

    public static class Builder {
        private TimeLine newTimeLine;

        public Builder() {
            newTimeLine = new TimeLine();
        }

        public TimeLine.Builder withServiceNumber(int serviceNumber) {
            newTimeLine.serviceNumber = serviceNumber;
            return this;
        }

        public TimeLine.Builder withServiceVariation(int serviceVariation) {
            newTimeLine.serviceVariation = serviceVariation;
            return this;
        }

        public TimeLine.Builder withQuestionType(int questionType) {
            newTimeLine.questionType = questionType;
            return this;
        }

        public TimeLine.Builder withQuestionCategory(int questionCategory) {
            newTimeLine.questionCategory = questionCategory;
            return this;
        }

        public TimeLine.Builder withQuestionSubcategory(int questionSubcategory) {
            newTimeLine.questionSubcategory = questionSubcategory;
            return this;
        }

        public TimeLine.Builder withResponseType(String responseType) {
            newTimeLine.responseType = responseType;
            return this;
        }

        public TimeLine.Builder withDateFrom(LocalDate date) {
            newTimeLine.date = date;
            return this;
        }

        public TimeLine.Builder withDateFrom(int time) {
            newTimeLine.time = time;
            return this;
        }

        public TimeLine build() {
            return newTimeLine;
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

    public LocalDate getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }
}
