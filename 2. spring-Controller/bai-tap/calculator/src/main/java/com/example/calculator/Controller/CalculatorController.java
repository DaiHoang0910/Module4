package com.example.calculator.Controller;

import com.example.calculator.Service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/calculate")
    public String calculate(ModelMap model,
                            @RequestParam(name = "number1", defaultValue = "0") double number1,
                            @RequestParam(name = "number2", defaultValue = "0") double number2,
                            @RequestParam(name = "calculation", defaultValue = "Addition(+)") String calculation) {
        try {
            double result = calculatorService.calculate(number1, number2, calculation);
            model.addAttribute("result", result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }

        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("calculator", calculation);
        return "index";
    }
}
