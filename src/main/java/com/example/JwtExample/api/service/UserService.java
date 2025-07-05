package com.example.JwtExample.api.service;


import com.example.JwtExample.api.Repository.UserRepo;
import com.example.JwtExample.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepo userRepo;

    public String createuser(User user) {
        userRepo.save(user);
        return "User Created SuccessFully";
    }

    public User findUserById(Integer id) {
        return userRepo.findUserById(id);
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public String deleteByID(Integer id) {
        userRepo.deleteById(id);
        return "User Deleted Successfully";
    }

    public String updateById(Integer id, User user) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();


            if (user.getName() != null) {
                existingUser.setName(user.getName());
            }
            if (user.getEmail() != null) {
                existingUser.setEmail(user.getEmail());
            }
            if (user.getAddress() != null) {
                existingUser.setAddress(user.getAddress());
            }

            userRepo.save(existingUser);
            return "User details successfully updated.";
        } else {
            return "User not found with ID: " + id;
        }
    }

        public User findByEmail(String email){
        return userRepo.findByEmail(email);
        }

}
