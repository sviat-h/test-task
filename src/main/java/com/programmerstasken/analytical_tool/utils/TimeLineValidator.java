package com.programmerstasken.analytical_tool.utils;

import com.programmerstasken.analytical_tool.entity.TimeLine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeLineValidator {

    public void validateAndSaveServiceNumber(TimeLine timeLine, String serviceNumber) {
        if (!serviceNumber.contains(Symbol.DOT.toString()) && CharactersValidator.isNumeric(serviceNumber)) {
            timeLine.setServiceNumber(Integer.parseInt(serviceNumber));
        } else if (serviceNumber.contains(Symbol.DOT.toString()) && CharactersValidator.isNumeric(serviceNumber)) {
            String[] splitServiceNumber = serviceNumber.split("\\.");
            timeLine.setServiceNumber(Integer.parseInt(splitServiceNumber[0]));
            timeLine.setServiceVariation(Integer.parseInt(splitServiceNumber[1]));
        } else {
            throw new IllegalArgumentException("Service Number (" + serviceNumber + ") is not valid!");
        }
    }

    public void validateAndSaveQuestionType(TimeLine timeLine, String questionType) {
        if (!questionType.contains(Symbol.DOT.toString()) && CharactersValidator.isNumeric(questionType)) {
            timeLine.setQuestionType(Integer.parseInt(questionType));
        } else if (questionType.contains(Symbol.DOT.toString()) && CharactersValidator.isNumeric(questionType)) {
            String[] splitQuestionType = questionType.split("\\.");

            if (splitQuestionType.length == 2) {
                timeLine.setQuestionType(Integer.parseInt(splitQuestionType[0]));
                timeLine.setQuestionCategory(Integer.parseInt(splitQuestionType[1]));
            } else if (splitQuestionType.length == 3) {
                timeLine.setQuestionType(Integer.parseInt(splitQuestionType[0]));
                timeLine.setQuestionCategory(Integer.parseInt(splitQuestionType[1]));
                timeLine.setQuestionSubcategory(Integer.parseInt(splitQuestionType[2]));
            } else {
                throw new IllegalArgumentException("Service Number (" + questionType + ") is not valid!");
            }
        } else {
            throw new IllegalArgumentException("Service Number (" + questionType + ") is not valid!");
        }
    }

    public void validateAndSaveResponseType(TimeLine timeLine, String responseType) {
        if (responseType.contains(Symbol.P.toString()) && responseType.length() == 1 || responseType.contains(Symbol.N.toString()) && responseType.length() == 1) {
            timeLine.setResponseType(responseType);
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
}
