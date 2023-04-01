package com.example.smilegate.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tai Nguyen
 */
@Data
public class OderRequest {
    private String name;
    private Long id;
    private Long customerId;
    private Long total;
    private Set<Long> gameIds = new HashSet<>();
}
