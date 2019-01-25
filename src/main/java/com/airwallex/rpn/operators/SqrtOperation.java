package com.airwallex.rpn.operators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import com.airwallex.rpn.exception.RPNCalculatorException;

public class SqrtOperation implements Operation {

	@Override
	public Double run(Double firstOperand, Double secondOperand) throws RPNCalculatorException {
		
		Double calculationResult = Math.sqrt(firstOperand);// new Double(Math.sqrt(firstOperand), MathContext.DECIMAL128)
				// .setScale(15, RoundingMode.HALF_UP).stripTrailingZeros();
		return calculationResult;
	}

	/*@Override
	public void run(Stack<BigDecimal> stack, Stack<Instruction> externalCommandStack, Stack<BigDecimal> resultantStack)
			throws RPNCalculatorException {
		
		 BigDecimal firstNumber = stack.pop();
		 BigDecimal calculationResult = new BigDecimal(sqrt(firstNumber.doubleValue()), MathContext.DECIMAL128)
				 .setScale(15, RoundingMode.HALF_UP).stripTrailingZeros();
		 stack.push(calculationResult);
		  
		 resultantStack.clear();
		 resultantStack.push(calculationResult);
	}*/
    /*@Override
    public void run(Stack<BigDecimal> stack, ExternalCommand externalCommand) throws InsufficientParametersException {
        BigDecimal firstNumber = popNumberFromStack(stack, externalCommand);
        BigDecimal calculationResult = new BigDecimal(sqrt(firstNumber.doubleValue()), MathContext.DECIMAL128)
                .setScale(15, RoundingMode.HALF_UP)
                .stripTrailingZeros();

        stack.push(calculationResult);
        externalCommand.addInternalCommand(
                new InternalCommandImpl(
                        InternalCommandType.PUSH,
                        calculationResult
                )
        );
    }*/
	
	
}
