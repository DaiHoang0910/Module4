package com.example.music.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 500, message = "Tên bài hát không được vượt quá 500 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]*$", message = "Tên bài hát không được chứa ký tự đặc biệt")
    private String name;

    @NotBlank(message = "Tên nghệ sĩ không được để trống")
    @Size(max = 200, message = "Tên nghệ sĩ không được vượt quá 200 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]*$", message = "Tên nghệ sĩ không được chứa ký tự đặc biệt")
    private String artist;

    @NotBlank(message = "Thể loại bài hát không được để trống")
    @Size(max = 300, message = "Thể loại bài hát không được vượt quá 300 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]*$", message = "Thể loại bài hát không được chứa ký tự đặc biệt")
    private String genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
