package com.airwallex.common;

import com.airwallex.enums.Operator;
import com.airwallex.exception.RpnCalculatorException;

public class Instruction {
    Operator operator;
    Double value;

    public Instruction(Operator operator, Double value) {
        this.operator = operator;
        this.value = value;
    }

    public String getReverseInstruction() throws RpnCalculatorException {
        if (operator.getOperandsNumber() < 1)
            throw new RpnCalculatorException(String.format("invalid operation for operator %s", operator.getSymbol()));

        return (operator.getOperandsNumber() < 2) ?
                String.format("%s", operator.getOpposite()) :
                String.format("%f %s %f", value, operator.getOpposite(), value);
    }
}
