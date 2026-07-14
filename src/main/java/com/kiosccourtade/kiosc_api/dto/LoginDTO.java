package com.kiosccourtade.kiosc_api.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO
        (
                @NotBlank
                String username,

                @NotBlank
                String password
        )
{
    @Override
    public String toString() {
        return "ProductDTO{username=%s, password=%s}"
                .formatted(username(), password());
    }
}
