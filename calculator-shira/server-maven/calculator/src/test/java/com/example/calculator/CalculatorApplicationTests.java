package com.example.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorApplicationTests {

    @Test
    public void testBlackSpaces(){
        Calculator calc = new Calculator();
        double result = calc.calculate(" 2+ 4");
        assertEquals(6, result);
    } 
    @Test
    public void testEmptyString(){
        Calculator calc = new Calculator();
        Exception exception = assertThrows(Exception.class, () -> {
            calc.calculate("");
        });
        assertEquals("Error, empty string",exception.getMessage());
    }
    @Test
    public void testOneNumber(){
        Calculator calc = new Calculator();
        Exception exception = assertThrows(Exception.class, () -> {
            calc.calculate("2+");
        });
        assertEquals("Error, The exercise is not written properly",exception.getMessage());
    }
    @Test
    public void testNonNumericCharacters(){
        Calculator calc = new Calculator();
        Exception exception = assertThrows(Exception.class, () -> {
            calc.calculate("7*j");
        });
        assertEquals("Error, Invalid exercise",exception.getMessage());
    }
    @Test
    public void testDecimalNumbers(){
        Calculator calc = new Calculator();
        double result = calc.calculate("7+2.4");
        assertEquals(9.4, result);
    } 
    @Test
    public void testInvalidDecimalNumbers(){
        Calculator calc = new Calculator();
        Exception exception = assertThrows(Exception.class, () -> {
            calc.calculate("7+2.3.4");
        });
        assertEquals("Error, Invalid decimal number",exception.getMessage());
    } 
}
