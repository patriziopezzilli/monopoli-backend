package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.MenuSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuSubscriberRepository extends JpaRepository<MenuSubscriber, Long> {

    List<MenuSubscriber> findByMerchant(String merchant);

    Integer countByMerchant(String merchant);
}

