package com.airwallex.rpn.output;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public interface OutputService {

    void print(Stack<Double> stack);
}
