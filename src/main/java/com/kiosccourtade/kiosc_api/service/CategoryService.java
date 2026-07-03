package com.kiosccourtade.kiosc_api.service;

import com.kiosccourtade.kiosc_api.exception.CategoryHasProductsException;
import com.kiosccourtade.kiosc_api.model.Category;
import com.kiosccourtade.kiosc_api.repository.CategoryRepository;
import com.kiosccourtade.kiosc_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    public Optional<Category> updateCategory(Long id, String name) {
        Optional<Category> category = categoryRepository.findById(id);
        category.ifPresent(n -> {n.setName(name); categoryRepository.save(n);});
        return category;

    }

    public Optional<Category> deleteById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            if (productRepository.countByCategory(category.get()) > 0) {
                throw new CategoryHasProductsException(id);
            }
            categoryRepository.deleteById(id);
        }
        return category;
    }
}
