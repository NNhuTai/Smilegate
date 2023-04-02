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
    private String pass;
    transient int age;
    private List<String> role;
    public Employee(String n, String p, int a) {
        name = n;
        pass = p;
        age = a;
    }
}
