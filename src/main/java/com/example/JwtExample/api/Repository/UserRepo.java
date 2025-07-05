package com.example.JwtExample.api.Repository;

import com.example.JwtExample.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findUserById(Integer id);

    User findByEmail(String email);
}
