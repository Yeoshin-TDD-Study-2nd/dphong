package com.dphong.caculator;

public class StringParser {
    private String input;
    private int numberOne;
    private int numberTwo;
    private String operator;

    public StringParser() {

    }

    public StringParser init(String input) {
        this.input = input;
        parseNumbers();
        parseOperator();
        return this;
    }

    public void parseOperator() {
        this.operator = input.replaceAll("[0-9]", "");
    }

    public void parseNumbers() {
        String[] stringNumbers = extractNumbers();

        this.numberOne = Integer.parseInt(stringNumbers[0]);
        this.numberTwo = Integer.parseInt(stringNumbers[1]);
    }

    private String[] extractNumbers() {
        return input.split("[^0-9]");
    }

    public int getNumberOne() {
        return numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    public String getOperator() {
        return operator;
    }
}
