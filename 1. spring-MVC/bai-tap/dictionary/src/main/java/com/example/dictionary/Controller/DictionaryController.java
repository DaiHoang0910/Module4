package com.example.dictionary.Controller;

import com.example.dictionary.Model.Dictionary;
import com.example.dictionary.Service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/search")
    public String search() {
        return "index";
    }

    @PostMapping("/search")
    public String meaning(@RequestParam("keyword") String keyword, Model model) {
        String meaning = dictionaryService.findMeaning(keyword);
        if ("Not found".equalsIgnoreCase(meaning)) {
            model.addAttribute("message", "Không tìm thấy nghĩa của từ \"" + keyword + "\".");
        } else {
            model.addAttribute("key", keyword);
            model.addAttribute("word", meaning);
        }

        return "index";
    }
}
