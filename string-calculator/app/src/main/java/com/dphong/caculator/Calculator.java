package com.dphong.caculator;

public class Calculator {
    private final StringParser parser;

    public Calculator(StringParser parser) {
        this.parser = parser;
    }

    public int calculate(String input) {
        parser.init(input);

        int n = parser.getNumberOne();
        int m = parser.getNumberTwo();
        String operator = parser.getOperator();

        return Operators.function(operator).apply(n, m);
    }
}
