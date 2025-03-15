package com.api.apitransacoesbank.controller;

import com.api.apitransacoesbank.dto.UserDTO;
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

//    @GetMapping("/sendMoney")
//    public ResponseEntity<Object> sendMoney(@Valid @RequestBody UserDTO userDTO , UserDTO userReceiver ) {
//        return ResponseEntity.status(HttpStatus.FOUND).body(bankService.sendMoney(userDTO , userReceiver));
//    }

}
