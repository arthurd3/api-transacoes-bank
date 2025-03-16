package com.api.apitransacoesbank.dto;

import jakarta.validation.constraints.NotNull;

public class BalanceRequestDTO {

    @NotNull
    private Double amount;

    public Double getAmount() {
        return amount;
    }
}
