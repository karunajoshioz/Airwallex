package com.airwallex.rpn.operators;


import com.airwallex.rpn.exception.RPNCalculatorException;

public class MinusOperation  implements Operation {

	@Override
	public Double run(Double firstOperand, Double secondOperand) throws RPNCalculatorException {
		return (secondOperand - firstOperand);
	}

}
