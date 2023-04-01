package com.example.smilegate.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Tai Nguyen
 */
@Entity
@Table(name = "game")
@Data
public class GameProduct {
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long CategoryId;
    private Long price;
}
