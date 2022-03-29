package com.example.bemanagementdevice.service.impl;

import com.example.bemanagementdevice.model.Category;
import com.example.bemanagementdevice.repository.CategoryRepository;
import com.example.bemanagementdevice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
