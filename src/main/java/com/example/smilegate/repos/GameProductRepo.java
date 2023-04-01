package com.example.smilegate.repos;

import com.example.smilegate.model.GameProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tai Nguyen
 */
public interface GameProductRepo extends JpaRepository<GameProduct, Long> {
}
