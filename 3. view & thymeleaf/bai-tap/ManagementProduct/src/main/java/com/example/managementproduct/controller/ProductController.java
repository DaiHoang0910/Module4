package com.example.managementproduct.controller;

import com.example.managementproduct.model.Product;
import com.example.managementproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String listProducts(@RequestParam(required = false) String name, Model model) {
        List<Product> products;
        if (name != null && !name.trim().isEmpty()) {
            products = productService.searchByName(name);
        } else {
            products = productService.findAll();
        }
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable String id, Model model) {
        try {
            int productId = Integer.parseInt(id);
            Product product = productService.findById(productId);
            if (product == null) {
                model.addAttribute("errorMessage", "Product with ID " + id + " not found!");
                return "error";
            }
            model.addAttribute("product", product);
            return "view";
        } catch (NumberFormatException e) {
            model.addAttribute("errorMessage", "Invalid product ID: " + id);
            return "error";
        }
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product(0, "", 0.0, 0, ""));
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("{id}/delete")
    public String deleteProduct(@PathVariable int id,
                                Model model) {
        if (productService.findById(id) == null) {
            model.addAttribute("message", "Product not found!");
            return "error";
        }
        productService.delete(id);
        return "redirect:/products";
    }
}
