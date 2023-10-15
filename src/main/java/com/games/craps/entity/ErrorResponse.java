package com.games.craps.entity;

import java.util.List;

public class ErrorResponse {
    private List<String> message;

    public ErrorResponse(){}

    public ErrorResponse(List<String> message) {
        this.message = message;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}