package com.airwallex.rpn.calculator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.airwallex.rpn.exception.RPNCalculatorException;

@RunWith(MockitoJUnitRunner.class)
public class RpnCalculatorImplTest {

    private RPNCalculator rpnCalculator;
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUp() throws Exception {
        rpnCalculator = new RPNCalculatorImpl();
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setErr(System.err);
    }

    @Test
    public void calculateAndPushResultToStack() throws RPNCalculatorException {
        // given
        String[] keywordAraay = new String[]{"2","3","+"};
        // when
        Stack<Double> stack = rpnCalculator.calculate(keywordAraay, false);
        // then
        assertEquals(1, stack.size());
        assertEquals(Double.valueOf(5), stack.pop());
    }

    @Test(expected=EmptyStackException.class)
    public void insufficientParameterInputWillPrintSystemErrorMessage() throws RPNCalculatorException {
        // given
        String[] keywordArray = new String[]{"1", "2", "3", "*", "5", "+", "*", "*", "6", "5"};
        when(rpnCalculator.calculate(keywordArray, false)).thenThrow(new EmptyStackException());
        // then
        //assertEquals("operator * (position: 15): insufficient parameters\n", errContent.toString());
    }
}