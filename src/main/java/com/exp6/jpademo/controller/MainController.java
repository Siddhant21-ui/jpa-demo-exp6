package com.exp6.jpademo.controller;

import com.exp6.jpademo.entity.Product;
import com.exp6.jpademo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final ProductRepository repo;

    public MainController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public List<Product> getAll() {
        return repo.findAll();
    }

    @GetMapping("/products/filter")
    public List<Product> filter(@RequestParam double min,
                                @RequestParam double max) {
        return repo.findByPriceRange(min, max);
    }
}