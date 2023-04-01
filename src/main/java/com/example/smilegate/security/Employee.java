package com.example.smilegate.security;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Tai Nguyen
 */
@Data
public class Employee implements Serializable {

    private String name;
    private String destination;
    transient int age;
    private List<String> role;
    public Employee(String n, String d, int a) {
        name = n;
        destination = d;
        age = a;
    }
}
