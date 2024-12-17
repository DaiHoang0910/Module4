package com.example.spicessanwich.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sandwich {
    @RequestMapping("/")
    public String loadIndex() {
        return "index";
    }

    @GetMapping(path = "/save")
    public String save(
            @RequestParam(value = "condiment", required = false) String[] condiment, ModelMap modelMap
    ) {
        if (condiment == null || condiment.length == 0) {
            modelMap.addAttribute("errorMessage", "Vui lòng chọn ít nhất một gia vị!");
            return "index";
        }

        modelMap.addAttribute("condiment", condiment);
        return "save";
    }
}
