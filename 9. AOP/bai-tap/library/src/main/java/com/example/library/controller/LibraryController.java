package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.BorrowRecord;
import com.example.library.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", libraryService.getAllBooks());
        return "book-list";
    }

    @PostMapping("/borrow/{bookId}")
    public String borrowBook(@PathVariable Long bookId, Model model) {
        try {
            BorrowRecord record = libraryService.borrowBook(bookId);
            model.addAttribute("message", "Bạn đã mượn sách thành công! Mã mượn sách của bạn là: " + record.getBorrowCode());
            return "success";
        } catch (IllegalArgumentException | IllegalStateException ex) {
            model.addAttribute("error", ex.getMessage());
            return "error";
        }
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String borrowCode, Model model) {
        try {
            libraryService.returnBook(borrowCode);
            model.addAttribute("message", "Bạn đã trả sách thành công!");
            return "success";
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
            return "error";
        }
    }
}



