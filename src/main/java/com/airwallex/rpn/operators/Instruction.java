package com.airwallex.rpn.operators;

import java.math.BigDecimal;

import com.airwallex.rpn.exception.RPNCalculatorException;

/**
 * 
 * @author karuna
 *
 */
public class Instruction 
{
    Operator operator;
    Double value;

    /**
     * 
     * @param operator
     * @param value
     */
    public Instruction(Operator operator, Double value) {
        this.operator = operator;
        this.value = value;
    }

    /**
     * 
     * @return
     * @throws RPNCalculatorException
     */
    public String getReverseInstruction() throws RPNCalculatorException {
        if (operator.getOperandsNumber() < 1)
            throw new RPNCalculatorException(String.format("invalid operation for operator %s", operator.getOperator()));

        return (operator.getOperandsNumber() < 2) ?
                String.format("%s", operator.getOppOperator()) :
                String.format("%f %s %f", value, operator.getOppOperator(), value);
    	//return operator.getOppOperator();
    }
}
