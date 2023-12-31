package com.games.craps.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorResponseTest {
    private ErrorResponse er;

    @BeforeEach
    void setUp(){
        List<String> error = new ArrayList<>();
        error.add("Test");
        er = new ErrorResponse(error);
    }

    @Test
    void testGetMessage(){
        List<String> testList = new ArrayList<>();
        testList.add("Test");

        assertEquals(testList, er.getMessage());
    }

    @Test
    void testSetMessage(){
        List<String> newList = new ArrayList<>();
        newList.add("TestNew");
        er.setMessage(newList);

        assertEquals(newList, er.getMessage());
    }

    @Test
    void testConstructor(){
        List<String> testList = new ArrayList<>();
        testList.add("Test");

        ErrorResponse errorResponse = new ErrorResponse(testList);

        assertEquals(testList, errorResponse.getMessage());
    }
}
