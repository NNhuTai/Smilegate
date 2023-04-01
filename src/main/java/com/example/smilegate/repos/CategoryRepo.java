package com.example.smilegate.repos;

import com.example.smilegate.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tai Nguyen
 */
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
