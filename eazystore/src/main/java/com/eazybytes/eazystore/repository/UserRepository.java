package com.eazybytes.eazystore.repository;

import com.eazybytes.eazystore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

}
