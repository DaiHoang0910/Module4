package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.BorrowRecord;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public BorrowRecord borrowBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        if (book.getQuantity() <= 0) {
            throw new IllegalStateException("Book is out of stock");
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        BorrowRecord record = new BorrowRecord();
        record.setBookId(bookId);
        record.setBorrowCode(generateBorrowCode());
        return borrowRecordRepository.save(record);
    }

    public void returnBook(String borrowCode) {
        if (!borrowCode.matches("\\d{5}")) {
            throw new IllegalArgumentException("Borrow code must be exactly 5 digits");
        }

        BorrowRecord record = borrowRecordRepository.findByBorrowCode(borrowCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid borrow code"));

        Book book = bookRepository.findById(record.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);

        borrowRecordRepository.delete(record);
    }

    private String generateBorrowCode() {
        return String.format("%05d", (int) (Math.random() * 100000));
    }
}
