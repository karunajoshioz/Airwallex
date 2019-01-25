package com.airwallex.rpn.controller;

import java.util.Scanner;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airwallex.rpn.calculator.RPNCalculator;
import com.airwallex.rpn.exception.RPNCalculatorException;
import com.airwallex.rpn.output.OutputService;

@Component
public class CalculatorController {

	@Autowired
    private OutputService outputService;
	
	@Autowired
    private RPNCalculator rpnCalculator;

	/**
	 * 
	 * @throws RPNCalculatorException
	 */
    public void process() throws  RPNCalculatorException{
    	Scanner scanner = new Scanner(System.in);
    	
        while(scanner.hasNextLine()) {
            String row = scanner.nextLine().trim();
            
        	if ("exit".equalsIgnoreCase(row)) {
                System.out.println("Exit!");
                break;
            }
        	
            String[] keywordArray = row.split("\\s");
            
            Stack<Double> stackList = rpnCalculator.calculate(keywordArray, false);
            outputService.print(stackList);
        }
        scanner.close();
    }




}
