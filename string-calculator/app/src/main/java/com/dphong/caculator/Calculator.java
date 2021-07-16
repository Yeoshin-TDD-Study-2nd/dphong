package com.dphong.caculator;

import java.util.regex.Pattern;

public class Calculator {

    public Calculator() {git st

    }

    public int calculate(String input) {
        Pattern p = Pattern.compile("[^0-9]");
        String[] numbers = input.split("[^0-9]");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);

        int result = 0;
        if (input.indexOf("+") > -1) {
            result = sum(n, m);
        }

        if (input.indexOf("-") > -1) {
            result = minus(n , m);
        }

        return result;
    }

    public int sum(int n, int m) {
        return n + m;
    }

    public int minus(int n, int m) {
        return n - m;
    }

}
