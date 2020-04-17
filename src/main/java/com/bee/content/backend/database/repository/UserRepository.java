package com.bee.content.backend.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bee.content.backend.database.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndMerchant(String username, String merchant);
}