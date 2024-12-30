package com.example.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "borrow_record")
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Borrow code is required")
    @Size(min = 5, max = 5, message = "Borrow code must be exactly 5 characters")
    private String borrowCode;

    @NotNull(message = "Book ID is required")
    private Long bookId;
}
