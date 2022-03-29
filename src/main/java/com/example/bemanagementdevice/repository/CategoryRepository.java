package com.example.bemanagementdevice.repository;

import com.example.bemanagementdevice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
