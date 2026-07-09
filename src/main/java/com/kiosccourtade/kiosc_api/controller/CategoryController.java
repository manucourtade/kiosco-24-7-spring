package com.kiosccourtade.kiosc_api.controller;

import com.kiosccourtade.kiosc_api.dto.CategoryDTO;
import com.kiosccourtade.kiosc_api.model.Category;
import com.kiosccourtade.kiosc_api.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> c = categoryService.getAll();
        return ResponseEntity.ok(c);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Optional<Category> c = categoryService.getById(id);
        return ResponseEntity.of(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@Valid @PathVariable Long id, @RequestBody CategoryDTO dto) {
        Optional<Category> c = categoryService.updateCategory(id, dto.name());
        return c.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Category> postCategory(@Valid @RequestBody CategoryDTO dto) {
        Category category = categoryService.addCategory(dto.name());
        return ResponseEntity.status(201).body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        Optional<Category> category = categoryService.deleteById(id);
        return category.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
