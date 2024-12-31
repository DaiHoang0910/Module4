package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories/{categoryId}/blogs")
public class CategoryBlogRestController {

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public List<Blog> getBlogsByCategory(@PathVariable("categoryId") int categoryId) {
        return blogService.getBlogsByCategoryId(categoryId);
    }
}
