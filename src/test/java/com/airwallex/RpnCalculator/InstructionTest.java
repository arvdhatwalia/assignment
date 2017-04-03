package com.airwallex.RpnCalculator;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Test;
import org.mockito.Mockito;

import com.airwallex.common.Instruction;
import com.airwallex.enums.Operator;
import com.airwallex.exception.RpnCalculatorException;

public class InstructionTest {

    @Test
    public void testReverseOneOperandInstruction() throws RpnCalculatorException {

        Operator mockOperator = Mockito.mock(Operator.class);
        when(mockOperator.getOperandsNumber()).thenReturn(1);
        when(mockOperator.getOpposite()).thenReturn("sqrt");

        Random r = new Random();
        Instruction instruction = new Instruction(mockOperator, r.nextDouble());

        assertEquals(String.format("%s", mockOperator.getOpposite()), instruction.getReverseInstruction());
    }

    @Test
    public void testReverseTwoOperandInstruction() throws RpnCalculatorException {

        Operator mockOperator = Mockito.mock(Operator.class);
        when(mockOperator.getOperandsNumber()).thenReturn(2);
        when(mockOperator.getOpposite()).thenReturn("-");

        Random r = new Random();
        double value = r.nextDouble();
        Instruction instruction = new Instruction(mockOperator, value);

        assertEquals(
                String.format("%f %s %f", value, mockOperator.getOpposite(), value),
                instruction.getReverseInstruction()
        );
    }

    @Test(expected = RpnCalculatorException.class)
    public void testInvalidOperandsNumber() throws RpnCalculatorException {
        Operator mockOperator = Mockito.mock(Operator.class);
        when(mockOperator.getOperandsNumber()).thenReturn(0);

        Random r = new Random();
        Instruction instruction = new Instruction(mockOperator, r.nextDouble());
        instruction.getReverseInstruction();
    }
}
