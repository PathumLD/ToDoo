package com.example.ToDoo.service;

import com.example.ToDoo.dto.UserRegistrationDTO;
import com.example.ToDoo.entity.User;
import com.example.ToDoo.repo.UserRepo;
import com.example.ToDoo.util.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoderUtil passwordEncoderUtil;



    public User registerUser(UserRegistrationDTO userDTO) {
        if (userRepo.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already in use.");
        }

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoderUtil.encode(userDTO.getPassword()));
        user.setRegisteredAt(LocalDateTime.now());
        user.setUserStatus(1);

        return userRepo.save(user);
    }


}
