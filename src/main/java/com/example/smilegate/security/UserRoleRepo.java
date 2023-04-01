package com.example.smilegate.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tai Nguyen
 */
@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, String> {
}

