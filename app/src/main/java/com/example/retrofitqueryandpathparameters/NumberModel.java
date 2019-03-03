package com.example.retrofitqueryandpathparameters;

public class NumberModel {

    private String text;
    private int number;
    private String type;

    public NumberModel(String text, int number, String type) {
        this.text = text;
        this.number = number;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }
}
