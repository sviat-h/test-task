package com.programmerstasken.analytical_tool.entity;

public abstract class Request {
    private int serviceNumber;
    private int serviceVariation;

    private int questionType;
    private int questionCategory;
    private int questionSubcategory;

    private String responseType;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;

        Request request = (Request) o;

        if (getServiceNumber() != request.getServiceNumber()) return false;
        if (getServiceVariation() != request.getServiceVariation()) return false;
        if (getQuestionType() != request.getQuestionType()) return false;
        if (getQuestionCategory() != request.getQuestionCategory()) return false;
        if (getQuestionSubcategory() != request.getQuestionSubcategory()) return false;
        return getResponseType() != null ? getResponseType().equals(request.getResponseType()) : request.getResponseType() == null;
    }

    @Override
    public int hashCode() {
        int result = getServiceNumber();
        result = 31 * result + getServiceVariation();
        result = 31 * result + getQuestionType();
        result = 31 * result + getQuestionCategory();
        result = 31 * result + getQuestionSubcategory();
        result = 31 * result + (getResponseType() != null ? getResponseType().hashCode() : 0);
        return result;
    }
}
