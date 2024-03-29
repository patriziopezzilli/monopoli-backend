package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.ChatMessage;
import com.bee.content.backend.database.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long>{

    List<Promotion> findByMerchant(String merchant);

    void deleteById(Long id);
}

