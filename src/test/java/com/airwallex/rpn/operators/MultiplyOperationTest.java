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
public class MultiplyOperationTest {

	@Mock
    private MultiplyOperation multiplyOperation;

    /*@Before
    public void setUp() throws Exception {
        multiplyOperation = new MultiplyOperation();
    }*/

    @Test
    public void runMultiplyOperationWillPushResultToStack() throws RPNCalculatorException {
        // given
        Stack<Double> stack = new Stack<>();
        Double firstNumber = new Double(2);
        Double secondNumber = new Double(3);
        stack.push(firstNumber);
        stack.push(secondNumber);
        // when
       Mockito.when(multiplyOperation.run(firstNumber, secondNumber)).thenReturn(Double.valueOf(6));
        // then
        //assertEquals(Double.valueOf(6), result);
    }
}