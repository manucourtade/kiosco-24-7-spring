package com.kiosccourtade.kiosc_api.service;

import com.kiosccourtade.kiosc_api.exception.NotFoundException;
import com.kiosccourtade.kiosc_api.model.Category;
import com.kiosccourtade.kiosc_api.model.Product;
import com.kiosccourtade.kiosc_api.repository.CategoryRepository;
import com.kiosccourtade.kiosc_api.repository.ProductRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product addProduct(String name, Double price, Integer stock, Long categoryId) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("Category", categoryId));
        product.setCategory(category);

        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }


    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public Product deleteById(Long id) {
        Product product = this.getById(id)
                .orElseThrow(() -> new NotFoundException("Product", id));
        productRepository.deleteById(id);
        return product;
    }

    public Product updateProduct(Long id, String name, Double price,
                                 Integer stock, Long categoryId) {
        Product product = this.getById(id)
                .orElseThrow(() -> new NotFoundException("Product", id));

        if (name != null) product.setName(name);
        if (price != null) product.setPrice(price);
        if (stock != null) product.setStock(stock);
        if (categoryId != null) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new NotFoundException("Category", categoryId));
            product.setCategory(category);
        }

        return productRepository.save(product);
    }

    public Product updateAllProduct(Long id, String name, Double price,
                                    Integer stock, Long categoryId) {
        Product product = this.getById(id)
                .orElseThrow(() -> new NotFoundException("Product", id));

        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Category", categoryId));
        product.setCategory(category);

        return productRepository.save(product);
    }
}
