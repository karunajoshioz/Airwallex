package com.airwallex.rpn.operators;

import java.math.BigDecimal;

import com.airwallex.rpn.exception.RPNCalculatorException;

public class MultiplyOperation  implements Operation {

	/*@Override
	public void run(Stack<BigDecimal> stack, Stack<Instruction> externalCommandStack, Stack<BigDecimal> resultantStack)
			throws RPNCalculatorException {
		BigDecimal firstNumber = stack.pop();
	    BigDecimal secondNumber = stack.pop();
	     
	    BigDecimal calculationResult = firstNumber.multiply(secondNumber);
	    stack.push(calculationResult);
	    
	    resultantStack.clear();
	    resultantStack.push(calculationResult);
	    		
	}
*/
	@Override
	public Double run(Double firstOperand, Double secondOperand) throws RPNCalculatorException {		
		return (firstOperand * secondOperand);
	}
	
	

   /* @Override
    public void run(Stack<BigDecimal> stack, ExternalCommand externalCommand) throws InsufficientParametersException {

        BigDecimal firstNumber = popNumberFromStack(stack, externalCommand);
        BigDecimal secondNumber = popSecondNumberFromStack(stack, firstNumber, externalCommand);
        BigDecimal calculationResult = firstNumber.multiply(secondNumber);

        stack.push(calculationResult);
        externalCommand.addInternalCommand(
                new InternalCommandImpl(
                        InternalCommandType.PUSH,
                        calculationResult
                )
        );
    }*/
}
