package com.api.apitransacoesbank.controller;


import com.api.apitransacoesbank.domain.user.User;
import com.api.apitransacoesbank.dto.UserDTO;
import com.api.apitransacoesbank.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO userDTO ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userDTO));
    }


    @GetMapping
    public ResponseEntity<Object> getAllUsers(@PageableDefault(page = 0 , size = 10 , sort = "id" , direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getAllUsers(pageable).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUser(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<User>> deleteUser(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editUser(@PathVariable(value = "id") UUID id , @Valid @RequestBody UserDTO userDTO ) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.editUser(id , userDTO));
    }


}
