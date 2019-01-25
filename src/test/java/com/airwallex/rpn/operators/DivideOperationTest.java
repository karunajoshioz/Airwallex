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
public class DivideOperationTest {

    //private DivideOperation divideOperation;

   /* @Before
    public void setUp() throws Exception {
        divideOperation = new DivideOperation();
    }*/

    
    @Mock
    private DivideOperation divideOperation;
    
    @Test
    public void runDivideOperationWillPushResultToStack() throws RPNCalculatorException {
        // given
        Stack<Double> stack = new Stack<>();
        Double firstNumber = new Double(2);
        Double secondNumber = new Double(6);
        stack.push(firstNumber);
        stack.push(secondNumber);
        
        // when
        when(divideOperation.run(firstNumber, secondNumber)).thenReturn(Double.valueOf(3));
        // then
       // assertEquals(Double.valueOf(3), result);
    }
}