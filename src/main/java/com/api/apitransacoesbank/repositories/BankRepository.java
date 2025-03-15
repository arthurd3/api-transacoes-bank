package com.api.apitransacoesbank.repositories;

import com.api.apitransacoesbank.domain.bank.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankRepository extends JpaRepository<Bank, UUID> {
}
