package com.api.apitransacoesbank.service;

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


    public User saveUser(UserDTO userDTO) {
        var user = new User();
        BeanUtils.copyProperties(userDTO, user);
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

    public UserDTO editUser(UUID id, UserDTO userDTO) {

        userRepository.findById(id).ifPresent(user -> {
            BeanUtils.copyProperties(userDTO, user , "id");
            userRepository.save(user);
        });

        return userDTO;
    }

}
