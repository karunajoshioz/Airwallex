package com.airwallex.rpn.operators;

import java.math.BigDecimal;

import com.airwallex.rpn.exception.RPNCalculatorException;


public interface Operation {

    //void run(Stack<BigDecimal> stack, ExternalCommand externalCommand) throws InsufficientParametersException;
	//void run(Stack<BigDecimal> stack, Stack<Instruction> externalCommandStack, Stack<BigDecimal> resultantStack) throws RPNCalculatorException;
	
	Double run(Double firstOperand, Double secondOperand) throws RPNCalculatorException;
}
