package com.api.apitransacoesbank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.UUID;

public record UserDTO(UUID id , @NotBlank String name, @NotBlank String email, @NotNull Double balance) {
}
