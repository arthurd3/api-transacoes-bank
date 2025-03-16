package com.api.apitransacoesbank.service;

import com.api.apitransacoesbank.dto.BalanceRequestDTO;
import com.api.apitransacoesbank.dto.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;


@Service
public class BankService {

    @Autowired
    private UserService userService;

    public TransactionDTO sendMoney(TransactionDTO transactionDTO) {
        var receiver = userService.getUserOrThrow(transactionDTO.receiverId());
        var sender = userService.getUserOrThrow(transactionDTO.senderId());

        if(sender.getBank().getAccount().getBalance().compareTo(transactionDTO.amount()) < 0)
            System.out.println("Saldo Insuficiente");

        sender.getBank().getAccount().setBalance(sender.getBank().getAccount().getBalance() - transactionDTO.amount());
        receiver.getBank().getAccount().setBalance(receiver.getBank().getAccount().getBalance() + transactionDTO.amount());
        userService.editUser(transactionDTO.senderId(),sender);
        userService.editUser(transactionDTO.receiverId(),receiver);
        return transactionDTO;



    }


    public Object setBalance(UUID id , BalanceRequestDTO amount) {
        var user = userService.getUserOrThrow(id);

        user.getBank().getAccount().setBalance(user.getBank().getAccount().getBalance() + amount.getAmount());

        userService.editUser(id,user);

        return user;
    }
}
