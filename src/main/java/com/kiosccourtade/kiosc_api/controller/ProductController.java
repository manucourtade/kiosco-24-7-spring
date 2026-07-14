package com.kiosccourtade.kiosc_api.controller;

import com.kiosccourtade.kiosc_api.dto.ProductDTO;
import com.kiosccourtade.kiosc_api.model.Category;
import com.kiosccourtade.kiosc_api.model.Product;
import com.kiosccourtade.kiosc_api.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> product = productService.getAll();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Optional<Product> product = productService.getById(id);
        return ResponseEntity.of(product);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> patchProduct(@Valid @PathVariable Long id,
                                                @RequestBody ProductDTO dto) {
        Product product = productService.updateProduct(id, dto.name(), dto.price(), dto.stock(), dto.categoryId());
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Product> putProduct(@Valid @PathVariable Long id,
                                               @RequestBody ProductDTO dto) {
        Product product =
                productService.updateAllProduct(id, dto.name(), dto.price(), dto.stock(), dto.categoryId());
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> postProduct(@Valid @RequestBody ProductDTO dto) {
        Product product = productService.addProduct(dto.name(), dto.price(), dto.stock(), dto.categoryId());
        return ResponseEntity.status(201).body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Product product = productService.deleteById(id);
        return ResponseEntity.ok(product);
    }
}
