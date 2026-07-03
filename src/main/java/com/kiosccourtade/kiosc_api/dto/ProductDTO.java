package com.kiosccourtade.kiosc_api.dto;

import com.kiosccourtade.kiosc_api.model.Category;

public record ProductDTO(Long id, String name,
                         Double price, Integer stock, Long categoryId) {
}
