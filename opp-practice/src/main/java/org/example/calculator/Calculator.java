package org.example.calculator;


import org.example.calculator.calculate.*;

import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        /*
        첫 번째 방법
        if ("+".equals(operator)) {
            return operand1 + operand2;
        } else if ("-".equals(operator)) {
            return operand1 - operand2;
        } else if ("*".equals(operator)) {
            return operand1 * operand2;
        } else if ("/".equals(operator)) {
            return operand1 / operand2;
        }
        return operand1 + operand2;
        */

        /*
        두 번째 방법
        return ArithmeticOperator.calculate(operand1, operator, operand2);
        */

        return arithmeticOperators.stream()
                .filter(arithmeticOperator ->  arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
