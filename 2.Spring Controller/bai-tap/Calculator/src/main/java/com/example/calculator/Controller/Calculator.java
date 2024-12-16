package com.example.calculator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
    @RequestMapping("/calculate")
    public String calculate(ModelMap model,
                            @RequestParam(name = "number1", defaultValue = "0") double number1,
                            @RequestParam(name = "number2", defaultValue = "0") double number2,
                            @RequestParam(name = "calculation", defaultValue = "") String calculator) {

        double result = 0;
        String error = null;
        switch (calculator) {
            case "Addition(+)":
                result = number1 + number2;
                calculator = "Addition";
                break;
            case "Subtraction(-)":
                result = number1 - number2;
                calculator = "Subtraction";
                break;
            case "Multiplication(X)":
                result = number1 * number2;
                calculator = "Multiplication";
                break;
            case "Division(/)":
                if (number2 == 0) {
                    error = "Không thể chia cho số 0, vui lòng nhập ở ô number 2 số khác 0!";
                } else {
                    result = number1 / number2;
                    calculator = "Division";
                }
                break;
        }
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("calculator", calculator);
        if (error != null) {
            model.addAttribute("error", error);
        } else {
            model.addAttribute("result", result);
        }
        return "index";
    }
}
