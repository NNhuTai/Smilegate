package com.example.smilegate.security;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tai Nguyen
 */
@RestController
@RequestMapping("/user")
public class AccessController {
    private final AccessService accessService;
    public AccessController(AccessService accessService){
        this.accessService = accessService;
    }
    @PostMapping("/register")
    public UserAccount register(@RequestBody Employee e) {
        return accessService.insertAccount(e);
    }
}
