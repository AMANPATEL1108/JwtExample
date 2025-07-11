package com.example.JwtExample.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "practicecrud")
public class User {


    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private  String address;
    private String password;


}
