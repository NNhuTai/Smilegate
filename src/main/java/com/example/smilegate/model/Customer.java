package com.example.smilegate.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Tai Nguyen
 */
@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public Customer(){}
    public Customer(String name){
        this.name = name;
    }
}
