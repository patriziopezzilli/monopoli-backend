package com.ristorantemonopoli.backend.database.repository;

import com.ristorantemonopoli.backend.database.entity.ConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<ConfigEntity, Long> {

    ConfigEntity findByName(String name);
}

