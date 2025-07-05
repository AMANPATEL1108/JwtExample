package com.example.JwtExample.api.controller;

import com.example.JwtExample.api.Jwt.JwtUtil;
import com.example.JwtExample.api.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.JwtExample.api.model.User;
import com.example.JwtExample.api.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            String token = jwtUtil.generateToken(user.getEmail());
            return ResponseEntity.ok(new LoginResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @PostMapping("/create")
    public String addUser(@RequestBody User user) {
        return userService.createuser(user);
    }

    @GetMapping("/getById/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("/getAll")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @DeleteMapping("/deleteById/{id}")
    public String delteById(@PathVariable Integer id) {
        return userService.deleteByID(id);
    }

    @PutMapping("/update/{id}")
    public String updateByID(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateById(id, user);
    }


}
