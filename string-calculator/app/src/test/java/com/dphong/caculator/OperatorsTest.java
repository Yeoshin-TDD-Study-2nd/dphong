package com.dphong.caculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorsTest {
    @Test
    void function() {
        assertEquals(2, Operators.function("+").apply(1, 1));
        assertEquals(3, Operators.function("-").apply(4, 1));
        assertEquals(6, Operators.function("*").apply(2, 3));
        assertEquals(2, Operators.function("/").apply(4, 2));
    }

    @Test
    void function_invalid_arguments() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Operators.function("=").apply(3, 2));

        assertEquals("invalid operator", exception.getMessage());
    }
}
