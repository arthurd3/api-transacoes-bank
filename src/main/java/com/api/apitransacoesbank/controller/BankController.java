package com.api.apitransacoesbank.controller;

import com.api.apitransacoesbank.dto.BalanceRequestDTO;
import com.api.apitransacoesbank.dto.TransactionDTO;
import com.api.apitransacoesbank.service.BankService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping(("/bank"))
public class BankController {

    @Autowired
    BankService bankService;

    @PostMapping("/sendMoney")
    public ResponseEntity<Object> sendMoney(@Valid @RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(bankService.sendMoney(transactionDTO));
    }

    @PostMapping("/setBalance/{id}")
    public ResponseEntity<?> setBalance(@PathVariable(value = "id") UUID id , @Valid @RequestBody BalanceRequestDTO amount) {
        return ResponseEntity.status(HttpStatus.OK).body(bankService.setBalance(id , amount));
    }
}
