package com.kevinjanvier.interview.data;

import java.util.List;

public class RequestData {

    private List<Integer> numbers;

    public RequestData() {
    }

    public RequestData(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}



