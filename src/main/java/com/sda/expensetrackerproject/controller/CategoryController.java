package com.sda.expensetrackerproject.controller;

import com.sda.expensetrackerproject.entity.Category;
import com.sda.expensetrackerproject.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")

public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    Collection<Category> categories(){
        return  categoryRepository.findAll();
    }


    @GetMapping("/category/{id}")
    ResponseEntity <?> getCategory(@PathVariable Integer id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @PostMapping("/category")
    ResponseEntity<Category> createCategory(@Validated @RequestBody Category category ) throws URISyntaxException{
        Category result = categoryRepository.save(category);
        return ResponseEntity.created(new URI("/api/category" +result.getId())).body(result);
    }

    @PutMapping("/category/{id}")
    ResponseEntity<Category> updateCategory(@Validated @RequestBody Category category){
        Category result = categoryRepository.save(category);
        return  ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/category/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Integer id){
        categoryRepository.deleteById(id);
        return ResponseEntity.ok().build();

    }

}
