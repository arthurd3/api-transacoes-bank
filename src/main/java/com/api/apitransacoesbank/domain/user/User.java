package com.api.apitransacoesbank.domain.user;


import com.api.apitransacoesbank.domain.bank.Bank;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name = "email" , nullable = false , unique = true)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL) // Se um usuário for criado, um banco também será
    @JoinColumn(name = "bank_id", referencedColumnName = "agency_id")
    private Bank bank = new Bank();

}
