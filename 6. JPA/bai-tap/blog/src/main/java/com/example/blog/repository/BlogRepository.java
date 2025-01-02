package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);

    List<Blog> findByCategoryId(int categoryId);

    List<Blog> findByTitleContainingIgnoreCase(String title);

}
