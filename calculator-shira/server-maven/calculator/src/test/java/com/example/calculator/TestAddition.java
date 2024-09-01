package com.example.calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestAddition{
    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        double result = calc.calculate("1+2");
        assertEquals(3, result);
    }
}