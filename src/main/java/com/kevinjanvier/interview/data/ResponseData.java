package com.kevinjanvier.interview.data;

import java.util.List;

public class ResponseData {

    private List<Integer> numbers;
    private String message;

    public ResponseData() {
    }

    public ResponseData(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public ResponseData(String message) {
        this.message = message;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
