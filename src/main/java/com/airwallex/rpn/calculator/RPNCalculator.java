package com.airwallex.rpn.calculator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

import com.airwallex.rpn.exception.RPNCalculatorException;

public interface RPNCalculator {
	Stack<Double> calculate(String[] keywordArray, boolean isUndoOperation) throws RPNCalculatorException;

}
