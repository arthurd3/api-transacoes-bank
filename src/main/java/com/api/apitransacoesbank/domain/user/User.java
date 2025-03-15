package com.api.apitransacoesbank.domain.user;


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
    @Column(name = "email" , nullable = false)
    private String email;
    @Column(name = "balance" , nullable = false)
    private Double balance;




}
