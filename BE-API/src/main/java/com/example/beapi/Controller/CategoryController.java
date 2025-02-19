package com.example.beapi.Controller;

import com.example.beapi.Model.ApiResponse;
import com.example.beapi.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/view")
    public ApiResponse getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/add")
    public ApiResponse addCategory(@RequestParam("name") String name) {
        return categoryService.saveCategory(name);
    }
}
