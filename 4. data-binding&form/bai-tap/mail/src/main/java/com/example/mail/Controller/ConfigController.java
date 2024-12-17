package com.example.mail.Controller;

import com.example.mail.Model.Config;
import com.example.mail.Service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @GetMapping("/config")
    public String showConfigForm(Model model) {
        Config currentConfig = configService.getConfig();
        model.addAttribute("config", currentConfig);
        return "config";
    }

    @PostMapping("/config")
    public String updateConfig(@ModelAttribute("config") Config newConfig, Model model) {
        configService.updateConfig(newConfig);
        model.addAttribute("config", newConfig);
        model.addAttribute("message", "Cấu hình đã được cập nhật thành công!");
        return "config";
    }
}
