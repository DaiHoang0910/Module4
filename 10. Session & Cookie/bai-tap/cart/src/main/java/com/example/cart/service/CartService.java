package com.example.cart.service;

import com.example.cart.model.CartItem;
import com.example.cart.model.Product;
import com.example.cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private List<CartItem> cart = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    public List<CartItem> getCart() {
        return cart;
    }

    public void addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + productId));
        cart.add(new CartItem(product, quantity));
    }

    public void updateQuantity(Long productId, int quantity) {
        for (CartItem item : cart) {
            if (item.getProduct().getId().equals(productId)) {
                item.setQuantity(quantity);
            }
        }
    }
}

