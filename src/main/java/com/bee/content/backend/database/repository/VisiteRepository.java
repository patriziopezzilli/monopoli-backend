package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.Visite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisiteRepository extends JpaRepository<Visite, Long>{

    Integer countByMerchant(String merchant);
}

