package com.api.apitransacoesbank.domain.bank;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "bank")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agency_id;

    @OneToOne(cascade = CascadeType.ALL) // Um banco tem uma conta
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account = new Account(); // Garante que um banco sempre tenha uma conta

}
