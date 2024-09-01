package com.example.calculator.controllers;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.Calculator;

@RestController
public class CalculatorController {
    @CrossOrigin(origins = "http://localhost:3000")

    @GetMapping("/{str}")
    public double calc(@PathVariable String str) {
        Calculator calculator = new Calculator();
        double res=calculator.calculate(str); 
        return res;
    }

}
