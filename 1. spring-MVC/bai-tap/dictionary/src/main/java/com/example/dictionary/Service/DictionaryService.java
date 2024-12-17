package com.example.dictionary.Service;

import com.example.dictionary.Model.Dictionary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictionaryService {
    private final List<Dictionary> dictionaries;

    public DictionaryService() {
        this.dictionaries = new ArrayList<>();
        dictionaries.add(new Dictionary("hello", "xin chào"));
        dictionaries.add(new Dictionary("goodbye", "tạm biệt"));
        dictionaries.add(new Dictionary("thank you", "cảm ơn"));
        dictionaries.add(new Dictionary("sorry", "xin lỗi"));
    }

    public String findMeaning(String keyword) {
        for (Dictionary dictionary : dictionaries) {
            if (keyword.equalsIgnoreCase(dictionary.getEn())) {
                return dictionary.getVi();
            }
        }
        return "Not found";
    }
}
