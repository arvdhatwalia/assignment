package com.airwallex.common;

import java.util.Stack;

import com.airwallex.enums.Operator;
import com.airwallex.exception.RpnCalculatorException;

public class RpnCalculator {

    private Stack<Double> valuesStack = new Stack<Double>();
    private Stack<Instruction> instructionsStack = new Stack<Instruction>();
    private int currentTokenIndex = 0;

    private Double tryParseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

 
    private void processToken(String token, boolean isUndoOperation) throws RpnCalculatorException {
        Double value = tryParseDouble(token);
        if (value == null) {
            processOperator(token, isUndoOperation);
        } else {
            // it's a digit
            valuesStack.push(Double.parseDouble(token));
            if (!isUndoOperation) {
                instructionsStack.push(null);
            }
        }
    }

    private void processOperator(String operatorString, boolean isUndoOperation) throws RpnCalculatorException {

        // check if there is an empty stack
        if (valuesStack.isEmpty()) {
            throw new RpnCalculatorException("empty stack");
        }

        // searching for the operator
        Operator operator = Operator.getEnum(operatorString);
        if (operator == null) {
            throw new RpnCalculatorException("invalid operator");
        }

        // clear value stack and instructions stack
        if (operator == Operator.CLEAR) {
            clearStacks();
            return;
        }

        // undo evaluates the last instruction in stack
        if (operator == Operator.UNDO) {
            undoLastInstruction();
            return;
        }

        // Checking that there are enough operand for the operation
        if (operator.getOperandsNumber() > valuesStack.size()) {
            throwInvalidOperand(operatorString);
        }

        // getting operands
        Double firstOperand = valuesStack.pop();
        Double secondOperand = (operator.getOperandsNumber() > 1) ? valuesStack.pop() : null;
        // calculate
        Double result = operator.calculate(firstOperand, secondOperand);

        if (result != null) {
            valuesStack.push(result);
            if (!isUndoOperation) {
                instructionsStack.push(new Instruction(Operator.getEnum(operatorString), firstOperand));
            }
        }

    }

    private void undoLastInstruction() throws RpnCalculatorException {
        if (instructionsStack.isEmpty()) {
            throw new RpnCalculatorException("no operations to undo");
        }

        Instruction lastInstruction = instructionsStack.pop();
        if (lastInstruction == null) {
            valuesStack.pop();
        } else {
            eval(lastInstruction.getReverseInstruction(), true);
        }
    }

    private void clearStacks() {
        valuesStack.clear();
        instructionsStack.clear();
    }

    private void throwInvalidOperand(String operator) throws RpnCalculatorException {
        throw new RpnCalculatorException(
                String.format("operator %s (position: %d): insufficient parameters", operator, currentTokenIndex));
    }

    public Stack<Double> getValuesStack() {
        return valuesStack;
    }

    public Double getStackItem(int index) {
        return valuesStack.get(index);
    }

    public void eval(String input) throws RpnCalculatorException {
        eval(input, false);
    }

    private void eval(String input, boolean isUndoOperation) throws RpnCalculatorException {
        if (input == null) {
            throw new RpnCalculatorException("Input cannot be null.");
        }
        currentTokenIndex = 0;
        String[] result = input.split("\\s");
        for (String aResult : result) {
            currentTokenIndex++;
            processToken(aResult, isUndoOperation);
        }
    }
}
