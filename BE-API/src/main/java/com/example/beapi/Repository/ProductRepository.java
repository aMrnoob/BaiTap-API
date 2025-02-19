package com.example.beapi.Repository;

import com.example.beapi.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long categoryId);
    List<Product> findTop10ByOrderByQuantitySoldDesc();
    @Query("SELECT p FROM Product p WHERE p.createdAt >= :sevenDaysAgo ORDER BY p.createdAt DESC")
    List<Product> findRecentProducts(LocalDateTime sevenDaysAgo);
}
