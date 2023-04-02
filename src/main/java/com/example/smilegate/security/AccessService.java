package com.example.smilegate.security;

import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tai Nguyen
 */
@Service
public class AccessService {

    private final UserRepository userAccountRepository;
    private final UserRoleRepo userRoleRepo;
    private final PasswordEncoder passwordEncoder;

    public AccessService(UserRepository userAccountRepository, UserRoleRepo userRoleRepo, PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.userRoleRepo = userRoleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserAccount insertAccount(Employee e) {
        Set<UserRole> roleSet = new HashSet<>();
        for(String role: e.getRole()) {
            UserRole r = new UserRole();
            r.setRole(role);
            roleSet.add(r);
        }
        userRoleRepo.saveAll(roleSet);

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(e.getName());
        userAccount.setPassword(passwordEncoder.encode(e.getPass()));
        userAccount.setActive(true);
        userAccount.setUserRoles(roleSet);
        userAccountRepository.save(userAccount);
        return userAccount;
    }
}
