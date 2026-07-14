package com.kiosccourtade.kiosc_api.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryDTO (Long id,

                           @NotBlank
                           String name) {

    @Override
    public String toString() {
        return "ProductDTO{name=%s}"
                .formatted(name());
    }
}
