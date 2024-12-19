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
    public String listProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            model.addAttribute("message", "Product not found!");
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "view";
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

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id,
                                Model model) {
        if (productService.findById(id) == null) {
            model.addAttribute("message", "Product not found!");
            return "error";
        }
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam String name, Model model) {
        List<Product> products = productService.searchByName(name);
        model.addAttribute("products", products);
        return "list";
    }
}
