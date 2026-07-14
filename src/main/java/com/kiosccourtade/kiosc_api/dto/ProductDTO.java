package com.kiosccourtade.kiosc_api.dto;

import jakarta.validation.constraints.*;

public record ProductDTO(Long id,
                         @NotBlank
                         String name,

                         @Positive
                         Double price,
                         @PositiveOrZero
                         Integer stock,

                         @Positive
                         Long categoryId) {
    @Override
    public String toString() {
        return "ProductDTO{name=%s, price=%s, stock=%s, categoryId=%s}"
                .formatted(name(), price(), stock(), categoryId());
    }
}

