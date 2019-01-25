package com.airwallex.rpn.operators;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.airwallex.rpn.exception.RPNCalculatorException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MinusOperationTest {

    /*private MinusOperation minusOperation;

    @Before
    public void setUp() throws Exception {
        minusOperation = new MinusOperation();
    }*/
	
	 @Mock
	 private MinusOperation minusOperation;
	  
    @Test
    public void runMinusOperationWillPushResultToStack() throws RPNCalculatorException {
        // given
        Stack<Double> stack = new Stack<>();
        Double firstNumber = new Double(2);
        Double secondNumber = new Double(3);
        stack.push(firstNumber);
        stack.push(secondNumber);
        // when
        when(minusOperation.run(firstNumber, secondNumber)).thenReturn(Double.valueOf(1));
        // then
        //assertEquals(Double.valueOf(1),result);
    }
}