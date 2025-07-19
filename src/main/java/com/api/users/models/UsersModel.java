package com.api.users.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UsersModel {
    
    @Id
    private Long id;

    private String first_name;
    private String last_name;
    private String gender;
    private String address;
    private String city;
    private int phone;
}
