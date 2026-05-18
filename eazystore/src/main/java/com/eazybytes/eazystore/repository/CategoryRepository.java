package com.eazybytes.eazystore.repository;

import com.eazybytes.eazystore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}