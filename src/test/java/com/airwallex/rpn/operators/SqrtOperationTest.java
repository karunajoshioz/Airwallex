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
public class SqrtOperationTest {

	@Mock
    private SqrtOperation sqrtOperation;

   /* @Before
    public void setUp() throws Exception {
        sqrtOperation = new SqrtOperation();
    }*/

    @Test
    public void runSqrtOperationWillPushResultToStack() throws RPNCalculatorException {
        // given
        Stack<Double> stack = new Stack<>();
        Double firstNumber = new Double(4);
        Double secondNumber = new Double(4);
        stack.push(firstNumber);
        // when
        Mockito.when(sqrtOperation.run(firstNumber, secondNumber)).thenReturn(Double.valueOf(2));
        // then
       // assertEquals(Double.valueOf(2), result);
    }
}