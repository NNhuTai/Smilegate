package com.example.smilegate.repos;

import com.example.smilegate.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tai Nguyen
 */
@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
