package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> getAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(int id, Blog blog) {
        if (blogRepository.existsById(id)) {
            blog.setId(id);
            blogRepository.save(blog);
        } else {
            throw new IllegalArgumentException("Blog with ID " + id + " not found");
        }
    }

    @Override
    public void remove(int id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Blog with ID " + id + " not found");
        }
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Blog with ID " + id + " not found"));
    }

    @Override
    public Page<Blog> searchByTitle(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContainingIgnoreCase(title, pageable);
    }

    @Override
    public List<Blog> getBlogsByCategoryId(int categoryId) {
        return blogRepository.findByCategoryId(categoryId);
    }
}
