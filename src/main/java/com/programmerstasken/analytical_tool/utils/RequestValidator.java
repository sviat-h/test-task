package com.programmerstasken.analytical_tool.utils;

import com.programmerstasken.analytical_tool.entity.Query;
import com.programmerstasken.analytical_tool.entity.Request;
import com.programmerstasken.analytical_tool.entity.TimeLine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequestValidator {

    public void validateAndSaveServiceNumber(Request request, String serviceNumber) {
        if (!serviceNumber.contains(Symbol.DOT.toString()) && CharactersValidator.isNumeric(serviceNumber)) {
            int intServiceNumber = Integer.parseInt(serviceNumber);
            if (intServiceNumber <= 10 && intServiceNumber >= 1) {
                request.setServiceNumber(intServiceNumber);
            } else {
                throw new IllegalArgumentException("Service Number must be in the range 1-10! Not " + intServiceNumber + "!");
            }
        } else if (serviceNumber.contains(Symbol.DOT.toString()) && CharactersValidator.isNumeric(serviceNumber)) {
            String[] splitServiceNumber = serviceNumber.split("\\.");
            if (splitServiceNumber.length == 2) {

                int intServiceNumber = Integer.parseInt(splitServiceNumber[0]);
                int intServiceVariation = Integer.parseInt(splitServiceNumber[1]);
                if (intServiceNumber <= 10 && intServiceNumber >= 1 && intServiceVariation <= 3 && intServiceVariation >= 1) {
                    request.setServiceNumber(Integer.parseInt(splitServiceNumber[0]));
                    request.setServiceVariation(Integer.parseInt(splitServiceNumber[1]));
                } else {
                    throw new IllegalArgumentException("Service Number must be in the range 1-10! Service Variation must be in the range 1-3!");
                }

            } else {
                throw new IllegalArgumentException("Service Number (" + serviceNumber + ") is not valid!");
            }
        } else if (serviceNumber.contains(Symbol.ASTERISK.toString()) && serviceNumber.length() == 1) {
            request.setServiceNumber(0); //0 means query match all  services/question types
        } else {
            throw new IllegalArgumentException("Service Number (" + serviceNumber + ") is not valid!");
        }
    }

    public void validateAndSaveQuestionType(Request request, String questionType) {
        if (!questionType.contains(Symbol.DOT.toString()) && CharactersValidator.isNumeric(questionType)) {

            int intQuestionType = Integer.parseInt(questionType);
            if (intQuestionType >= 1 && intQuestionType <= 10) {
                request.setQuestionType(intQuestionType);
            } else {
                throw new IllegalArgumentException("Question Type must be in the range 1-10! Not " + questionType + "!");
            }
        } else if (questionType.contains(Symbol.DOT.toString()) && CharactersValidator.isNumeric(questionType)) {
            String[] splitQuestionType = questionType.split("\\.");

            if (splitQuestionType.length == 2) {

                int intQuestionType = Integer.parseInt(splitQuestionType[0]);
                int intQuestionCategory = Integer.parseInt(splitQuestionType[1]);
                if (intQuestionType >= 1 && intQuestionType <= 10 && intQuestionCategory >= 1 && intQuestionCategory <= 20) {
                    request.setQuestionType(intQuestionType);
                    request.setQuestionCategory(intQuestionCategory);
                } else {
                    throw new IllegalArgumentException("Question Type must be in the range 1-10! Question Category must be in the range 1-20!");
                }
            } else if (splitQuestionType.length == 3) {

                int intQuestionType = Integer.parseInt(splitQuestionType[0]);
                int intQuestionCategory = Integer.parseInt(splitQuestionType[1]);
                int intQuestionSubcategory = Integer.parseInt(splitQuestionType[2]);
                if (intQuestionType >= 1 && intQuestionType <= 10 && intQuestionCategory >= 1 && intQuestionCategory <= 20 && intQuestionSubcategory >= 1 && intQuestionSubcategory <= 5) {
                    request.setQuestionType(intQuestionType);
                    request.setQuestionCategory(intQuestionCategory);
                    request.setQuestionSubcategory(intQuestionSubcategory);
                } else {
                    throw new IllegalArgumentException("Question Type must be in the range 1-10! Question Category must be in the range 1-20! Question Subcategory must be in the range 1-5!");
                }
            } else {
                throw new IllegalArgumentException("Question Type (" + questionType + ") is not valid!");
            }
        } else if (questionType.contains(Symbol.ASTERISK.toString()) && questionType.length() == 1) {
            request.setQuestionType(0); //0 means query match all  services/question types
        } else {
            throw new IllegalArgumentException("Question Type (" + questionType + ") is not valid!");
        }
    }

    public void validateAndSaveResponseType(Request request, String responseType) {
        if (responseType.contains(Symbol.P.toString()) && responseType.length() == 1 || responseType.contains(Symbol.N.toString()) && responseType.length() == 1) {
            request.setResponseType(responseType);
        } else {
            throw new IllegalArgumentException("Response Type (" + responseType + ") is not valid!");
        }
    }

    public void validateAndSaveDate(TimeLine timeLine, String date) {
        if (CharactersValidator.isDate(date)) {
            timeLine.setDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        } else {
            throw new IllegalArgumentException("Date (" + date + ") is not valid!");
        }
    }

    public void validateAndSaveTime(TimeLine timeLine, String time) {
        if (CharactersValidator.isNumeric(time)) {
            int number = Integer.parseInt(time);
            if (number >= 0) {
                timeLine.setTime(number);
            } else {
                throw new IllegalArgumentException("Time (" + time + ") is not valid!");
            }
        } else {
            throw new IllegalArgumentException("Time (" + time + ") is not valid!");
        }
    }

    public void validateAndSaveDateFromAndDateTo(Query query, String dateFromAndDateTo) {
        if (!dateFromAndDateTo.contains(Symbol.HYPHEN.toString()) && CharactersValidator.isDate(dateFromAndDateTo)) {
            query.setDateFrom(LocalDate.parse(dateFromAndDateTo, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        } else if (dateFromAndDateTo.contains(Symbol.HYPHEN.toString())) {
            String[] splitDateFromAndDateTo = dateFromAndDateTo.split(Symbol.HYPHEN.toString());
            if (splitDateFromAndDateTo.length == 2) {
                String dateFrom = splitDateFromAndDateTo[0];
                String dateTo = splitDateFromAndDateTo[1];

                if (CharactersValidator.isDate(dateFrom) && CharactersValidator.isDate(dateTo)) {
                    query.setDateFrom(LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                    query.setDateTo(LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                } else {
                    throw new IllegalArgumentException("DateFrom (" + dateFrom + ") or DateTo (" + dateTo + ") is not valid!");
                }
            }
        }
    }
}
