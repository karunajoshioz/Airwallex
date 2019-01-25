package com.airwallex.rpn.output;

import java.text.DecimalFormat;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class OutputServiceImpl implements OutputService {

    @Override
    public void print(Stack<Double> stack) {
        System.out.print("stack: [ ");
        
        DecimalFormat decFormat = new DecimalFormat("0.##########");
        
        for(Double stackElement : stack) {
        	decFormat.format(stackElement);
        	System.out.print(stackElement + " ");
        }
        System.out.print("]\n");
        System.out.println(">");
    }
}
