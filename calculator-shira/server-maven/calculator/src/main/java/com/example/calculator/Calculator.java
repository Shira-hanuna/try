package com.example.calculator;
import java.lang.String;
import java.util.Stack;
import java.util.Hashtable;

public class Calculator{
    Hashtable<Character, Ioperation> operationsInstance = new Hashtable<>();
    int index=0;

    public double calculate(String str){ 
        operationsInstance.put('+', new Addition());
        operationsInstance.put('-', new Subtraction());
        operationsInstance.put('*', new Multiplication());
        operationsInstance.put('/', new Division());
        
        Stack<Double>numbers=new Stack<>();
        Stack<Character>operation=new Stack<>();

        checkEmptyString(str);
        str=str.replaceAll("\\s+", "");
        int length=str.length();
        
        for (index = 0 ; index < length ;index++) {
            char c = str.charAt(index);
            if(Character.isDigit(c)){
               numbers.push(getNumbers(str));
               index--;
            }
            else if(c == '+' || c == '-' || c == '*' || c == '/'){
                if(!operation.isEmpty() && precedence(operation.peek(), c))
                    numbers.push(actionCalculation(operation.pop(), numbers.pop(), numbers.pop()));
                operation.push(c);
            }
            else
                throw new IllegalArgumentException ("Error, Invalid exercise");
        }

        while(!operation.isEmpty()){
            double n1=numbers.pop();
            if(!numbers.isEmpty())
                numbers.push(actionCalculation(operation.pop(), n1, numbers.pop()));
            else
                throw new IllegalArgumentException ("Error, The exercise is not written properly");
        }
        return numbers.pop(); 
    }

    public boolean precedence(char c1, char c2) {
        if(c1 == '*' || c1 == '/' && c2 =='+' || c2 == '-')
           return true;
        return false;
    }

    public double actionCalculation(char op, double num1, double num2) {
        Ioperation operation = operationsInstance.get(op);
        if(op =='/' && num1 == 0)
            throw new ArithmeticException ("Error, cannot be divided by 0");
        if (operation != null) 
            return operation.calc(num1,num2);
        return 0;
    } 

    public void checkEmptyString(String str){
        if(str == "") 
           throw new IllegalArgumentException ("Error, empty string");
    }  

    public double getNumbers(String str){
        int countDot = 0;
        String num = "";
        while (index < str.length() && (Character.isDigit(str.charAt(index))|| str.charAt(index)=='.')) {
            if(countDot == 1 && str.charAt(index) == '.')
               throw new IllegalArgumentException ("Error, Invalid decimal number");
            else if(str.charAt(index) == '.')
               countDot++;
            num = num + String.valueOf(str.charAt(index));
            index++;
        }
        return Double.parseDouble(num);
    } 
}     

