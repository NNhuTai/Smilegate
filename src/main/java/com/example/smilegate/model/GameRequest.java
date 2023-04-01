package com.example.smilegate.model;

import lombok.Data;

/**
 * @author Tai Nguyen
 */
@Data
public class GameRequest {
    private String name;
    private Long categoryId;
    private Long price;
}
