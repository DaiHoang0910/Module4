package com.example.dictionary.Controller;

import com.example.dictionary.Model.Dictionary;
import com.example.dictionary.Service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DictionaryController {
    private DictionaryService dictionaryService = new DictionaryService();

    @GetMapping("/search")
    public String search() {
        return "index";
    }

    @PostMapping("/search")
    public String meaning(@RequestParam String keyword, Model model) {
        List<Dictionary> dictionaries = this.dictionaryService.findAll();
        for (int i = 0; i < dictionaries.size(); i++) {
            if (keyword.equalsIgnoreCase(dictionaries.get(i).getEn())) {
                model.addAttribute("word", dictionaries.get(i).getVi());
                model.addAttribute("key", keyword);
                return "index";
            }
        }
        model.addAttribute("key", keyword);
        model.addAttribute("word", "Not found");
        return "index";
    }
}
