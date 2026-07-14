package com.kiosccourtade.kiosc_api.dto;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotBlank
        String role){
        @Override
        public String toString() {
                return "ProductDTO{username=%s, password=%s, role=%s}"
                        .formatted(username(), password(), role());
        }
}
