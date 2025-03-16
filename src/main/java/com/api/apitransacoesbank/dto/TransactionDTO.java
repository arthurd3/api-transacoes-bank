package com.api.apitransacoesbank.dto;

import java.util.UUID;

public record TransactionDTO(UUID receiverId , UUID senderId , Double amount) {
}
