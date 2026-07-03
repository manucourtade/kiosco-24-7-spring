package com.kiosccourtade.kiosc_api.repository;

import com.kiosccourtade.kiosc_api.model.Category;
import com.kiosccourtade.kiosc_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    long countByCategory(Category category);
}
