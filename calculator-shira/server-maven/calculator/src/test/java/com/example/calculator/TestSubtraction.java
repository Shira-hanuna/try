package com.example.calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestSubtraction{
    
    @Test
    public void testSubtraction (){
        Calculator calc = new Calculator();
        double result = calc.calculate("20-2");
        assertEquals(18, result);
    }
}