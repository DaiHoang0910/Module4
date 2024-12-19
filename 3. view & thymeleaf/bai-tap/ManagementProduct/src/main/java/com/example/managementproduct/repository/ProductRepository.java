package com.example.managementproduct.repository;

import com.example.managementproduct.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Laptop", 1500.0, 10, "High-end laptop"));
        products.add(new Product(2, "Smartphone", 800.0, 20, "Latest model"));
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println("Product found: " + product.getName());
                return product;
            }
        }
        System.out.println("Product with ID " + id + " not found!");
        return null;
    }

    public String save(Product product) {
        Product existingProduct = findById(product.getId());
        if (existingProduct == null) {
            products.add(product);
            return "Product added successfully!";
        } else {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setDescription(product.getDescription());
            return "Product updated successfully!";
        }
    }

    public String delete(int id) {
        Product product = findById(id);
        if (product != null) {
            products.remove(product);
            return "Product deleted successfully!";
        }
        return "Product with ID " + id + " not found!";
    }

    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No products found with name containing: " + name);
        } else {
            System.out.println(result.size() + " product(s) found with name containing: " + name);
        }
        return result;
    }
}
