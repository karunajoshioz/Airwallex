package com.airwallex.rpn.output;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class OutputServiceImplTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private OutputServiceImpl outputService;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        outputService = new OutputServiceImpl();
    }

    @Test
    public void print() {
        // given
        Stack<Double> stack = new Stack<>();
        Double firstNumber = new Double(1);
        Double secondNumber = new Double(2);
        stack.push(firstNumber);
        stack.push(secondNumber);
        // when
        outputService.print(stack);
        // then
        assertTrue(outContent.toString().contains("1.0 2.0"));
    } 
}