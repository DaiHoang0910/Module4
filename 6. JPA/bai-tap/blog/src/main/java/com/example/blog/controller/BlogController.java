package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    private final IBlogService blogService;
    private final ICategoryService categoryService;

    @Autowired
    public BlogController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getAllBlogs(@RequestParam(value = "search", required = false) String search,
                              @RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "5") int size,
                              Model model) {
        Page<Blog> blogs;
        if (search != null && !search.trim().isEmpty()) {
            blogs = blogService.searchByTitle(search, PageRequest.of(page, size));
        } else {
            blogs = blogService.getAll(PageRequest.of(page, size));
        }
        model.addAttribute("blogs", blogs);
        model.addAttribute("search", search);
        return "list";
    }

    @GetMapping("/new")
    public String createBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.getAll());
        return "create";
    }

    @PostMapping
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Blog created successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}")
    public String viewBlog(@PathVariable int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "view";
    }

    @GetMapping("/{id}/edit")
    public String editBlogForm(@PathVariable int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("categories", categoryService.getAll());
        return "update";
    }

    @PostMapping("/{id}")
    public String updateBlog(@PathVariable int id, @ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(id, blog);
        redirectAttributes.addFlashAttribute("message", "Blog updated successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable int id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Blog deleted successfully!");
        return "redirect:/blogs";
    }
}
