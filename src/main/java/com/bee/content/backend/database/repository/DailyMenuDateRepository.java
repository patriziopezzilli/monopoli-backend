package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.MenuDelGiornoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyMenuDateRepository extends JpaRepository<MenuDelGiornoData, Long> {

    MenuDelGiornoData getByMerchant(String merchant);
}

