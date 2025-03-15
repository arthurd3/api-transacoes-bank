package com.api.apitransacoesbank.service;

import com.api.apitransacoesbank.domain.user.User;
import com.api.apitransacoesbank.dto.UserDTO;
import com.api.apitransacoesbank.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User saveUser(UserDTO userDTO) {
        var user = new User();
        BeanUtils.copyProperties(userDTO, user);

        if (userRepository.existsByEmail(user.getEmail()) || userRepository.existsByName(user.getName()))
            throw new IllegalArgumentException("A user with the same email or username already exists.");

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


}
