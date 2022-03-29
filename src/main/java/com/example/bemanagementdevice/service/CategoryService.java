package com.example.bemanagementdevice.service;

import com.example.bemanagementdevice.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void save(Category category);
    Category findById(int id);
    void delete(Category category);
}
