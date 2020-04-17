package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.MerchantEntity;
import com.bee.content.backend.database.entity.Visite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<MerchantEntity, Long>{

    MerchantEntity getByCode(String code);
}

