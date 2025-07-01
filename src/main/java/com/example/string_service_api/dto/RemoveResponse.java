package com.example.string_service_api.dto;

public class RemoveResponse {
    private String input;
    private String result;

    public RemoveResponse(String input, String result) {
        this.input = input;
        this.result = result;
    }

    public String getInput() {
        return input;
    }

    public String getResult() {
        return result;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
