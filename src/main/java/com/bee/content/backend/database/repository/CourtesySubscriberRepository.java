package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.CourtesySubscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourtesySubscriberRepository extends JpaRepository<CourtesySubscriber, Long> {

    List<CourtesySubscriber> findByMerchant(String merchant);

    Integer countByMerchant(String merchant);
}

