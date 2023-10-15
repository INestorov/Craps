package com.games.craps.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorResponseTest {
    private ErrorResponse er;

    @BeforeEach
    public void setUp(){
        List<String> error = new ArrayList<>();
        error.add("Test");
        er = new ErrorResponse(error);
    }

    @Test
    public void getMessageTest(){
        List<String> testList = new ArrayList<>();
        testList.add("Test");

        assertEquals(testList, er.getMessage());
    }

    @Test
    public void setMessageTest(){
        List<String> newList = new ArrayList<>();
        newList.add("TestNew");
        er.setMessage(newList);

        assertEquals(newList, er.getMessage());
    }

    @Test
    public void constructorTest(){
        List<String> testList = new ArrayList<>();
        testList.add("Test");

        ErrorResponse errorResponse = new ErrorResponse(testList);

        assertEquals(testList, errorResponse.getMessage());
    }
}
