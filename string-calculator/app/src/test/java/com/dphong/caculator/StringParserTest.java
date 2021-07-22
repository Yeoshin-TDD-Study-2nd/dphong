package com.dphong.caculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {
    @Test
    void create() {
        StringParser parser = new StringParser().init("1+2");
    }

    @Test
    void parse() {
        StringParser parser = new StringParser().init("1+2");
        parser.parseNumbers();
        parser.parseOperator();

        assertEquals(1, parser.getNumberOne());
        assertEquals(2, parser.getNumberTwo());
        assertEquals("+", parser.getOperator());
    }
}
