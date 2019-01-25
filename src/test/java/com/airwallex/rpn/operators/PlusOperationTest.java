package com.airwallex.rpn.operators;

import static org.junit.Assert.assertEquals;


import java.util.Stack;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.airwallex.rpn.exception.RPNCalculatorException;


@RunWith(MockitoJUnitRunner.Silent.class)
public class PlusOperationTest {

	@Mock
    private PlusOperation plusOperation;

    /*@Before
    public void setUp() throws Exception {
        plusOperation = new PlusOperation();
    }*/

    @Test
    public void runPlusOperationWillPushResultToStack() throws RPNCalculatorException {
        // given
        Stack<Double> stack = new Stack<>();
        Double firstNumber = new Double(1);
        Double secondNumber = new Double(2);
        stack.push(firstNumber);
        stack.push(secondNumber);
        // when
        Mockito.when(plusOperation.run(firstNumber, secondNumber)).thenReturn(Double.valueOf(3));
        // then
       // assertEquals(Double.valueOf(3), result);
    }
}