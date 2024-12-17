package com.example.convertmoney.Controller;

import com.example.convertmoney.Service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConvertController {
    @Autowired
    private ConvertService convertService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("usd") String usdInput, Model model) {
        if (!convertService.isValidNumber(usdInput)) {
            model.addAttribute("error", "Vui lòng nhập một số dương hợp lệ!");
            return "index";
        }

        double usd = Double.parseDouble(usdInput);
        double vnd = convertService.convertUsdToVnd(usd);

        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "index";
    }
}
