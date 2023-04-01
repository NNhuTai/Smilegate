package com.example.smilegate.security;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Tai Nguyen
 */
@Entity
@Table(name = "roles")
@Data
public class UserRole {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true)
    private String role;
}