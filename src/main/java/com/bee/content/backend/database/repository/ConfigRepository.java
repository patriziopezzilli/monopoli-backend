package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.ConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<ConfigEntity, Long> {

    ConfigEntity findByNameAndMerchant(String name, String merchant);
}

