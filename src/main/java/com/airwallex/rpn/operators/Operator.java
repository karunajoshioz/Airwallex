package com.airwallex.rpn.operators;

public enum Operator {

    PLUS("+","-",2),
    MINUS("-","+",2),
    MULTIPLY("*","/",2),
    DIVIDE("/","*",2),
    SQRT("sqrt","pow", 1) ,
    CLEAR("clear",null,0),
    UNDO("undo",null,0);

    private String operator;
    private String oppOperator;
    private int operandsNumber;

    Operator(String operator, String opposite, int operandsNumber) {
        this.operator = operator;
        this.oppOperator = opposite;
        this.operandsNumber = operandsNumber;
    }

    public String getOperator() {
        return operator;
    }   
    public int getOperandsNumber() {
        return operandsNumber;
    }

    public String getOppOperator() {
		return oppOperator;
	}

	public static boolean isValidOperator(String operator) {
        for (Operator validOperator : Operator.values()) {
            if (validOperator.getOperator().equals(operator)) {
                return true;
            }
        }
        return false;
    }

    public static Operator getOperator(String operator) {
        for (Operator validOperator : Operator.values()) {
            if (validOperator.getOperator().equals(operator)) {
                return validOperator;
            }
        }
        return null;
    }
    
    public static Operator getOppOperator(String operator) {
        for (Operator validOperator : Operator.values()) {
            if (validOperator.getOperator().equals(operator)) {
                return getOperator(validOperator.getOppOperator());
            }
        }
        return null;
    }

    public static Operation getOperation(Operator operator) {
        switch (operator) {
            case PLUS:
                return new PlusOperation();
            case MINUS:
                return new MinusOperation();
            case MULTIPLY:
                return new MultiplyOperation();
            case DIVIDE:
                return new DivideOperation();
            case CLEAR:
                return new ClearOperation();
            case SQRT:
                return new SqrtOperation();
            default:
                throw new RuntimeException("Invalid operator:" + operator);
        }
    }
    
    public static Operation getOppOperation(Operator operator) {
        switch (operator) {
            case PLUS:
                return new MinusOperation();
            case MINUS:
                return new PlusOperation();
            case MULTIPLY:
                return new DivideOperation();
            case DIVIDE:
                return new MultiplyOperation();
            case CLEAR:
                return new ClearOperation();
            case SQRT:
            	throw new RuntimeException("Opposite operator not defined for opperator:" + operator);
            default:
                throw new RuntimeException("Opposite operator not defined for opperator:" + operator);
        }
    }
}
