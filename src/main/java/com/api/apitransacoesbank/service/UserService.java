package com.api.apitransacoesbank.service;

import com.api.apitransacoesbank.domain.bank.Account;
import com.api.apitransacoesbank.domain.bank.Bank;
import com.api.apitransacoesbank.domain.user.User;
import com.api.apitransacoesbank.dto.UserDTO;
import com.api.apitransacoesbank.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User saveUser(Object userDTO) {
        var user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setBank(new Bank());
        user.getBank().setAccount(new Account());

        System.out.println(user.getBank().getAccount().getBalance());
        return userRepository.save(user);
    }

    public Page<User> getAllUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public Optional<User> getUser(UUID id){
        return userRepository.findById(id);
    }

    public Optional<User> deleteUser(UUID id){
        var returnUser = userRepository.findById(id);
        userRepository.findById(id).ifPresent(user -> userRepository.deleteById(id));
        return returnUser;
    }

    public Object editUser(UUID id, Object userDTO) {

        userRepository.findById(id).ifPresent(user -> {
            BeanUtils.copyProperties(userDTO, user , "id");
            userRepository.save(user);
        });

        return userDTO;
    }


    public User getUserOrThrow(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
