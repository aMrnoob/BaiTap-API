package com.example.beapi.Service;

import com.example.beapi.Model.ApiResponse;
import com.example.beapi.Model.Product;
import com.example.beapi.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ApiResponse addProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);
        return new ApiResponse(true, "Thêm sản phẩm thành công.", savedProduct);
    }

    public ApiResponse getAllProductsByCategory(Long categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        if (products.isEmpty()) {
            return new ApiResponse(false, "Không có sản phẩm nào trong danh mục này.");
        }
        return new ApiResponse(true, "Lấy danh sách sản phẩm thành công.", products);
    }

    public ApiResponse getTop10BestSellingProducts() {
        List<Product> products = productRepository.findTop10ByOrderByQuantitySoldDesc();
        if (products.isEmpty()) {
            return new ApiResponse(false, "Không có sản phẩm bán chạy nào.");
        }
        return new ApiResponse(true, "Lấy danh sách sản phẩm bán chạy thành công.", products);
    }

    public ApiResponse getRecentProducts() {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        List<Product> products = productRepository.findRecentProducts(sevenDaysAgo);
        if (products.isEmpty()) {
            return new ApiResponse(false, "Không có sản phẩm nào được tạo trong 7 ngày qua.");
        }
        return new ApiResponse(true, "Lấy danh sách sản phẩm mới nhất thành công.", products);
    }
}
