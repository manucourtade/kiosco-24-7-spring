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
}
