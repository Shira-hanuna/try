package com.example.calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestDivision{
     @Test
    public void testDivision (){
        Calculator calc = new Calculator();
        double result =calc.calculate("12/4");
        assertEquals(3, result);
    }
      @Test
    public void testDivisionByZero(){
        Calculator calc = new Calculator();
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.calculate("12/0");
        });
        assertEquals("Error, cannot be divided by 0", exception.getMessage());
    }
}