package com.example.ToDoo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;

    @PrePersist
    protected void onCreate() {
        registeredAt = new Date();
    }


}
