package com.starlab.microbiome.microbiomdata.service;

import com.starlab.microbiome.microbiomdata.model.User;
import com.starlab.microbiome.microbiomdata.repo.UserRepo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User lookUpUser(User user) {
        return userRepo.findByNameAndEmail(user.getName(), user.getEmail());
    }

    public User create(User user) {
        return userRepo.save(user);
    }
}
