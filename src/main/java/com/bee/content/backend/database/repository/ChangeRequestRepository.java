package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.ChangeRequest;
import com.bee.content.backend.database.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChangeRequestRepository extends JpaRepository<ChangeRequest, Long>{

    ChangeRequest findByTypeAndMerchantAndCompleted(String type, String merchant, Boolean completed);
}

