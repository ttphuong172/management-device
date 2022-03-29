package com.example.bemanagementdevice.controller;

import com.example.bemanagementdevice.model.Block;
import com.example.bemanagementdevice.model.Category;
import com.example.bemanagementdevice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categorys")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody Category category){
        Category categoryCurrent=categoryService.findById(id);
        if (categoryCurrent==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryCurrent.setName(category.getName());
        categoryService.save(categoryCurrent);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Category category=categoryService.findById(id);
        if (category==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.delete(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
