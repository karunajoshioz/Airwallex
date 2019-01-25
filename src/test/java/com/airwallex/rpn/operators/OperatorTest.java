package com.airwallex.rpn.operators;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OperatorTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void validOperatorWillReturnTrue() {
        // given
        String operator = "+";
        // when
        boolean isValid = Operator.isValidOperator(operator);
        // then
        assertTrue(isValid);
    }

    @Test
    public void invalidOperatorWillReturnFalse() {
        // given
        String operator = "jump";
        // when
        boolean isValid = Operator.isValidOperator(operator);
        // then
        assertFalse(isValid);
    }

    @Test
    public void getOperatorReturnEnumOperator() {
        // given
        String operator = "+";
        // when
        Operator PLUS = Operator.getOperator(operator);
        // then
        assertEquals(Operator.PLUS, PLUS);
    }

    @Test
    public void getOperationWillReturnRelatedOperationInstance() {
        // when
        Operation operation = Operator.getOperation(Operator.CLEAR);
        // then
        assertTrue(operation instanceof ClearOperation);
    }
}