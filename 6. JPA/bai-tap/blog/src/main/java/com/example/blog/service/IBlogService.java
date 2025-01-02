package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    Page<Blog> getAll(Pageable pageable);

    void save(Blog blog);

    void update(int id, Blog blog);

    void remove(int id);

    Blog findById(int id);

    Page<Blog> searchByTitle(String title, Pageable pageable);

    List<Blog> getBlogsByCategoryId(int categoryId);

    List<Blog> searchByTitle(String title);
}
