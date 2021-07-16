package com.dphong.caculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void plus() {
        assertEquals(2, calculator.calculate("1+1"));
        assertEquals(3, calculator.calculate("1+2"));
        assertEquals(4, calculator.calculate("2+2"));
        assertEquals(4, calculator.calculate("1+3"));
        assertEquals(5, calculator.calculate("4+1"));
    }

    @Test
    void minus() {
        assertEquals(0, calculator.calculate("1-1"));
        assertEquals(1, calculator.calculate("3-2"));
        assertEquals(3, calculator.calculate("5-2"));
        assertEquals(4, calculator.calculate("5-1"));
        assertEquals(1, calculator.calculate("5-4"));
    }

    @Test
    void multiply() {
        assertEquals(1, calculator.calculate("1*1"));
        assertEquals(6, calculator.calculate("3*2"));
        assertEquals(10, calculator.calculate("5*2"));
        assertEquals(5, calculator.calculate("5*1"));
        assertEquals(20, calculator.calculate("5*4"));
    }
}
