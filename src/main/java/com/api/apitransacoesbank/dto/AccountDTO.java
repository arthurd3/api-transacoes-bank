package com.api.apitransacoesbank.dto;

import com.api.apitransacoesbank.domain.bank.AccountType;

import java.util.UUID;

public record AccountDTO(UUID id , AccountType accountType , Double balance) {
}
