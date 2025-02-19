package com.example.beapi.Controller;

import com.example.beapi.Model.ApiResponse;
import com.example.beapi.Model.Product;
import com.example.beapi.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ApiResponse addProduct(@ModelAttribute Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/category/{categoryId}")
    public ApiResponse getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getAllProductsByCategory(categoryId);
    }

    @GetMapping("/top10-bestsellers")
    public ApiResponse getTop10BestSellingProducts() {
        return productService.getTop10BestSellingProducts();
    }

    @GetMapping("/recent")
    public ApiResponse getRecentProducts() {
        return productService.getRecentProducts();
    }
}
