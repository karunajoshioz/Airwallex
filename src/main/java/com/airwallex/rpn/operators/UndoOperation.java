/*package com.airwallex.rpn.operators;

import com.airwallex.rpn.commands.ExternalCommand;
import com.airwallex.rpn.commands.InternalCommand;
import com.airwallex.rpn.commands.InternalCommandType;
import com.airwallex.rpn.exception.RPNCalculatorException;

import java.math.BigDecimal;
import java.util.Stack;

public class UndoOperation {

    public static void run(Stack<BigDecimal> valuesStack, Stack<ExternalCommand> instructionsStack) throws InsufficientParametersException {
        ExternalCommand latestExternalCommand = instructionsStack.pop();

        while (!latestExternalCommand.isExternalStackEmpty()) {
            InternalCommand latestInternalCommand = latestExternalCommand.getLatestInternalCommand();
            InternalCommandType type = latestInternalCommand.getInternalCommandType();
            BigDecimal number = latestInternalCommand.getNumber();

            if (InternalCommandType.POP.equals(type)) {
            	valuesStack.push(number);
                break;
            } else if (InternalCommandType.PUSH.equals(type)) {
            	valuesStack.pop();
                break;
            } else {
                throw new RuntimeException("Invalid type: " + type);
            }
        }
    }
	
	public static void run(Stack<BigDecimal> valuesStack, Stack<Instruction> instructionsStack, Stack<BigDecimal> resultantStack)
						throws  RPNCalculatorException {
		 if (instructionsStack == null && instructionsStack.isEmpty()) {
	            throw new RPNCalculatorException("no operations to undo");
	     }

		 if(!instructionsStack.isEmpty()) {
		        Instruction lastInstruction = instructionsStack.pop();
		        if (lastInstruction == null || Operator.UNDO == lastInstruction.operator) {
		            valuesStack.pop();
		        } 
		        else {
		        	//if(Operator.getOperator(lastInstruction.getReverseInstruction()) != null) {
		        		Operator.getOperation(Operator.getOperator(lastInstruction.getReverseInstruction()))
		        				.run(valuesStack, instructionsStack, resultantStack);
		        	//}
		        }
	        }else {
	        	 valuesStack.pop();
	        }
    }
}
*/