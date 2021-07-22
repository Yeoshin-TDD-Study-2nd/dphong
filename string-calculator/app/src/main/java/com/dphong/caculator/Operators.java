package com.dphong.caculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operators {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DEVIDE("/", (a, b) -> a / b)
    ;
    private String symbol;
    private BiFunction<Integer, Integer, Integer> function;

    Operators(String symbol, BiFunction<Integer, Integer, Integer> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public static BiFunction<Integer, Integer, Integer> function(String operator) {
        return Arrays.stream(Operators.values())
                .filter(op -> op.symbol.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid operator"))
                .function;
    }
}
