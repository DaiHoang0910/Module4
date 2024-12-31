package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blogs")
public class BlogDetailRestController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable("id") int id) {
        return blogService.findById(id);
    }
}
