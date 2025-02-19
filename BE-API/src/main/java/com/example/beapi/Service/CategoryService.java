package com.example.beapi.Service;

import com.example.beapi.Model.ApiResponse;
import com.example.beapi.Model.Category;
import com.example.beapi.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ApiResponse getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            return new ApiResponse(false, "Không có danh mục nào.");
        }
        return new ApiResponse(true, "Lấy danh sách danh mục thành công.", categories);
    }

    public ApiResponse saveCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return new ApiResponse(true, "Thêm danh mục thành công.", category);
    }
}
