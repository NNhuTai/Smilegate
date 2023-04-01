package com.example.smilegate.repos;

import com.example.smilegate.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tai Nguyen
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
