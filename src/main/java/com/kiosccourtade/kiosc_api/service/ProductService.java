package com.kiosccourtade.kiosc_api.service;

import com.kiosccourtade.kiosc_api.model.Category;
import com.kiosccourtade.kiosc_api.model.Product;
import com.kiosccourtade.kiosc_api.repository.CategoryRepository;
import com.kiosccourtade.kiosc_api.repository.ProductRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public Product addProduct(String name, Double price, Integer stock, Long categoryId) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        Category category = categoryRepository.findById(categoryId).orElse(null);
        product.setCategory(category);

        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> deleteById(Long id) {
        Optional<Product> product = this.getById(id);
        product.ifPresent(p -> productRepository.deleteById(id));
        return product;
    }

    public Optional<Product> updateProduct(Long id, String name, Double price,
                                           Integer stock, Long categoryId) {
        Optional<Product> product = this.getById(id);
        product.ifPresent(p -> {
            if (name != null) p.setName(name);
            if (price != null) p.setPrice(price);
            if (stock != null) p.setStock(stock);
            if (categoryId != null) {
                Category category = categoryRepository.findById(categoryId).orElse(null);
                p.setCategory(category);
            }
            productRepository.save(p);
        });
        return product;
    }

    public Optional<Product> updateAllProduct(Long id, String name, Double price,
                                              Integer stock, Long categoryId) {
        Optional<Product> product = this.getById(id);
        product.ifPresent(p -> {
            p.setName(name);
            p.setPrice(price);
            p.setStock(stock);
            Category category = categoryRepository.findById(categoryId).orElse(null);
            p.setCategory(category);
            productRepository.save(p);
        });
        return  product;
    }
}
