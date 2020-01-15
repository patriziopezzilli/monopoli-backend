package com.ristorantemonopoli.backend.database.repository;

import com.ristorantemonopoli.backend.database.entity.CourtesySubscriber;
import com.ristorantemonopoli.backend.database.entity.MenuSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtesySubscriberRepository extends JpaRepository<CourtesySubscriber, Long> {

}

