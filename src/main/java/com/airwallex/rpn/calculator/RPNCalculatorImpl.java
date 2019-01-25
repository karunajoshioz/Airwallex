package com.airwallex.rpn.calculator;

import java.util.Stack;

import org.springframework.stereotype.Component;

import com.airwallex.rpn.exception.RPNCalculatorException;
import com.airwallex.rpn.operators.Instruction;
import com.airwallex.rpn.operators.Operator;
import com.airwallex.rpn.utility.Utility;


@Component
public class RPNCalculatorImpl implements RPNCalculator{

	private Stack<Double> valuesStack =  new Stack<>();
	private Stack<Instruction> instructionsStack =  new Stack<>();	
	
	@Override
	public Stack<Double> calculate(String[] keywordArray, boolean isUndoOperation) throws RPNCalculatorException {
		
		for (String keyword : keywordArray)
		{			
			Double value = Utility.parseDouble(keyword);			
			if (value == null) 
			{
				//its a operator
				
				if (!Operator.isValidOperator(keyword)) {
					throw new RuntimeException("Invalid operator: " + keyword);
		        }
						
				processOperator(keyword, isUndoOperation);
			}
			else {
				valuesStack.push(Utility.parseDouble(keyword));
				
	            if (!isUndoOperation) {
	                instructionsStack.push(null);
	            }
			}
		}
		
		return valuesStack;
	}
	
	/**
	 * 
	 * @param operatorString
	 * @param isUndoOperation
	 * @throws RPNCalculatorException
	 */
	private void processOperator(String operatorString, boolean isUndoOperation) throws RPNCalculatorException 
	{		
		try {
			if (Operator.getOperator(operatorString).equals(Operator.CLEAR)) {
				 clearStacks();
				 return;
            } 
			
			if (Operator.getOperator(operatorString).equals(Operator.UNDO)) {
			     // undo evaluates the last instruction in stack
	            undoLastInstruction();
	            return;
	        }
			//else {
            //{
            	Operator operator = Operator.getOperator(operatorString);
            	
            	// getting operands
            	Double firstOperand = valuesStack.pop();
            	Double secondOperand = (operator.getOperandsNumber() > 1) ? valuesStack.pop() : null;
               
                // calculate
            	Double result = Operator.getOperation(Operator.getOperator(operatorString)).run(firstOperand, secondOperand);

                if (result != null) {
                    valuesStack.push(result);
                    if (!isUndoOperation) {
                        instructionsStack.push(new Instruction(Operator.getOperator(operatorString), firstOperand));
                    }
                }
			//}    
        } catch (RPNCalculatorException e) {
        	System.err.println(e.getMessage());
            System.err.flush();
        }
		//return result;
	} 
	
	/**
	 * 
	 * @throws RPNCalculatorException
	 */
	private void undoLastInstruction() throws RPNCalculatorException {
        if (instructionsStack == null && instructionsStack.isEmpty()) {
            throw new RPNCalculatorException("no operations to undo");
        }

        if(!instructionsStack.isEmpty()) {
	        Instruction lastInstruction = instructionsStack.pop();
	        if (lastInstruction == null) {
	            valuesStack.pop();
	        } else {
	        	String[] keywordArray = lastInstruction.getReverseInstruction().split("\\s");
	        	calculate(keywordArray, true);
	        }
        }else {
        	 valuesStack.pop();
        }
    }
	
	/**
	 * 
	 */
	private void clearStacks() {
    	if(valuesStack != null)
    		valuesStack.clear();
    	
    	if(instructionsStack != null)
    		instructionsStack.clear();
    }

}
