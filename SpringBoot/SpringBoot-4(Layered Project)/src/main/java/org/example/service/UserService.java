package org.example.service;

import org.example.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //get
    public List<String> getUser(){
       return userRepo.findAll();

    }
    //add
    public void addUser(String name){
        userRepo.save(name);
    }

}
