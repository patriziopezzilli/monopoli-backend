package com.ristorantemonopoli.backend.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ristorantemonopoli.backend.database.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}