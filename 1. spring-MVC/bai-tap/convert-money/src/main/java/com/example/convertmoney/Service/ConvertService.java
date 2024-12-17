package com.example.convertmoney.Service;

import org.springframework.stereotype.Service;

@Service
public class ConvertService {
    private static final int RATE = 27000;

    public double convertUsdToVnd(double usd) {
        return usd * RATE;
    }

    public boolean isValidNumber(String input) {
        try {
            double value = Double.parseDouble(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
