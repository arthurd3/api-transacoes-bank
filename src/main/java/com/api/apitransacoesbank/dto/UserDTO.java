package com.api.apitransacoesbank.dto;

import com.api.apitransacoesbank.domain.bank.Bank;
import jakarta.validation.constraints.NotBlank;


import java.util.UUID;

public record UserDTO(UUID id , @NotBlank String name, @NotBlank String email , Bank bank ) {
}
