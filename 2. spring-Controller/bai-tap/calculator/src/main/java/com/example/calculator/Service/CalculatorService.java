package com.example.calculator.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

@Service
public class CalculatorService {
    private final Map<String, BiFunction<Double, Double, Double>> operations = new HashMap<>();

    public CalculatorService() {
        operations.put("Addition(+)", (a, b) -> a + b);
        operations.put("Subtraction(-)", (a, b) -> a - b);
        operations.put("Multiplication(X)", (a, b) -> a * b);
        operations.put("Division(/)", (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Không thể chia cho số 0!");
            }
            return a / b;
        });
    }

    public double calculate(double number1, double number2, String operationLabel) {
        BiFunction<Double, Double, Double> operation = operations.get(operationLabel);
        if (operation == null) {
            throw new IllegalArgumentException("Phép tính không hợp lệ: " + operationLabel);
        }
        return operation.apply(number1, number2);
    }
}
