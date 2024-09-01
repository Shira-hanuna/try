package com.example.calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestMultiplication{
   
    @Test
    public void testMultiplication(){
        Calculator calc = new Calculator();
        double result = calc.calculate("12*4");
        assertEquals(48, result);
    }
}