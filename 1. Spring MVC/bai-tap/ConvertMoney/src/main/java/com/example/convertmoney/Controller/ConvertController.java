package com.example.convertmoney.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class ConvertController {
    private int rate = 27000;
    private double vnd;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "index";
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public String value(@RequestParam("usd") double usd, ModelMap model, Model model1) {
        vnd = usd * rate;
        model.addAttribute("vnd", vnd);
        model1.addAttribute("usd", usd);
        return "index";
    }
}
