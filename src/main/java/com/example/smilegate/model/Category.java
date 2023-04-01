package com.example.smilegate.model;

import jakarta.persistence.*;

/**
 * @author Tai Nguyen
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
