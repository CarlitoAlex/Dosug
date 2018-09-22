package com.dosug.demo.service;
import com.dosug.demo.model.User;
import com.dosug.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User findUserById(UUID uuid){
        return userRepo.findByUserId(uuid);
    }

    public User findUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public void saveUser(User user){
        userRepo.save(user);
    }

}
