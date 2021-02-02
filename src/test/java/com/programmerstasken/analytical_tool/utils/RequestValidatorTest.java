package com.programmerstasken.analytical_tool.utils;

import com.programmerstasken.analytical_tool.entity.Query;
import com.programmerstasken.analytical_tool.entity.TimeLine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RequestValidatorTest {

    RequestValidator requestValidator = new RequestValidator();
    static TimeLine actualTimeLine = new TimeLine();
    static Query actualQuery = new Query();
    static TimeLine expectedTimeLine = new TimeLine();
    static Query expectedQuery = new Query();

    @BeforeAll
    static void setUp() {
        actualTimeLine.setServiceNumber(1);
        actualTimeLine.setServiceVariation(1);
        actualTimeLine.setQuestionType(8);
        actualTimeLine.setQuestionCategory(15);
        actualTimeLine.setQuestionSubcategory(1);
        actualTimeLine.setResponseType("P");
        actualTimeLine.setDate(LocalDate.of(2012, 10, 15));
        actualTimeLine.setTime(83);

        actualQuery.setServiceNumber(1);
        actualQuery.setServiceVariation(1);
        actualQuery.setQuestionType(8);
        actualQuery.setQuestionCategory(0);
        actualQuery.setQuestionSubcategory(0);
        actualQuery.setResponseType("N");
        actualQuery.setDateFrom(LocalDate.of(2012, 1, 1));
        actualQuery.setDateTo(LocalDate.of(2012, 12, 1));
    }

    @Test
    void validateAndSaveServiceNumber() {
        requestValidator.validateAndSaveServiceNumber(expectedTimeLine, "1.1");
        requestValidator.validateAndSaveServiceNumber(expectedQuery, "1.1");

        assertEquals(expectedTimeLine.getServiceNumber(), actualTimeLine.getServiceNumber());
        assertEquals(expectedTimeLine.getServiceVariation(), actualTimeLine.getServiceVariation());

        IllegalArgumentException expectedException1 = assertThrows(IllegalArgumentException.class, () ->
                requestValidator.validateAndSaveServiceNumber(expectedQuery, "11.1"));
        assertEquals("Service Number must be in the range 1-10! Service Variation must be in the range 1-3!",
                expectedException1.getMessage());

        IllegalArgumentException expectedException2 = assertThrows(IllegalArgumentException.class, () ->
                requestValidator.validateAndSaveServiceNumber(expectedQuery, "1.1."));
        assertEquals("Service Number (1.1.) is not valid!",
                expectedException2.getMessage());
    }

    @Test
    void validateAndSaveQuestionType() {
        requestValidator.validateAndSaveQuestionType(expectedTimeLine, "8.15.1");
        requestValidator.validateAndSaveQuestionType(expectedQuery, "8");

        assertEquals(expectedTimeLine.getQuestionType(), actualTimeLine.getQuestionType());
        assertEquals(expectedTimeLine.getQuestionCategory(), actualTimeLine.getQuestionCategory());
        assertEquals(expectedQuery.getQuestionCategory(), actualQuery.getQuestionCategory());

        IllegalArgumentException expectedException1 = assertThrows(IllegalArgumentException.class, () ->
                requestValidator.validateAndSaveQuestionType(expectedQuery, "8.15.1.1"));
        assertEquals("Question Type (8.15.1.1) is not valid!",
                expectedException1.getMessage());

        IllegalArgumentException expectedException2 = assertThrows(IllegalArgumentException.class, () ->
                requestValidator.validateAndSaveQuestionType(expectedTimeLine, "8.15.6"));
        assertEquals("Question Type must be in the range 1-10! Question Category must be in the range 1-20! Question Subcategory must be in the range 1-5!",
                expectedException2.getMessage());
    }

    @Test
    void validateAndSaveResponseType() {
        requestValidator.validateAndSaveResponseType(expectedTimeLine, "P");
        requestValidator.validateAndSaveResponseType(expectedQuery, "N");

        assertEquals(expectedTimeLine.getResponseType(), actualTimeLine.getResponseType());
        assertEquals(expectedTimeLine.getResponseType(), actualTimeLine.getResponseType());
        assertEquals(expectedQuery.getResponseType(), actualQuery.getResponseType());

        IllegalArgumentException expectedException1 = assertThrows(IllegalArgumentException.class, () ->
                requestValidator.validateAndSaveResponseType(expectedQuery, "NN"));
        assertEquals("Response Type (NN) is not valid!",
                expectedException1.getMessage());

        IllegalArgumentException expectedException2 = assertThrows(IllegalArgumentException.class, () ->
                requestValidator.validateAndSaveResponseType(expectedTimeLine, "1"));
        assertEquals("Response Type (1) is not valid!",
                expectedException2.getMessage());
    }

    @Test
    void validateAndSaveDate() {
        requestValidator.validateAndSaveDate(expectedTimeLine, "15.10.2012");

        assertEquals(expectedTimeLine.getDate(), actualTimeLine.getDate());

        IllegalArgumentException expectedException = assertThrows(IllegalArgumentException.class, () ->
                requestValidator.validateAndSaveDate(expectedTimeLine, "15.13.2012"));
        assertEquals("Date (15.13.2012) is not valid!",
                expectedException.getMessage());
    }

    @Test
    void validateAndSaveTime() {
        requestValidator.validateAndSaveTime(expectedTimeLine, "83");

        assertEquals(expectedTimeLine.getTime(), actualTimeLine.getTime());

        IllegalArgumentException expectedException = assertThrows(IllegalArgumentException.class, () ->
                requestValidator.validateAndSaveTime(expectedTimeLine, "-83"));
        assertEquals("Time (-83) is not valid!",
                expectedException.getMessage());
    }

    @Test
    void validateAndSaveDateFromAndDateTo() {
        requestValidator.validateAndSaveDateFromAndDateTo(expectedQuery, "01.01.2012-01.12.2012");

        assertEquals(expectedQuery.getDateFrom(), actualQuery.getDateFrom());
        assertEquals(expectedQuery.getDateTo(), actualQuery.getDateTo());

        IllegalArgumentException expectedException = assertThrows(IllegalArgumentException.class, () ->
                requestValidator.validateAndSaveDateFromAndDateTo(expectedQuery, "01.01.2012-01.121.2012"));
        assertEquals("DateFrom (01.01.2012) or DateTo (01.121.2012) is not valid!",
                expectedException.getMessage());
    }

    @Test
    static void tearDown() {
        assertEquals(expectedQuery, actualQuery);
        assertEquals(expectedTimeLine, actualTimeLine);
    }
}