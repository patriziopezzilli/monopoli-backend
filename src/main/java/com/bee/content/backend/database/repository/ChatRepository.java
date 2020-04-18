package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.ChatMessage;
import com.bee.content.backend.database.entity.Visite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatMessage, Long>{

    Integer countByMerchant(String merchant);

    List<ChatMessage> findByAuthorOrRecipient(String from, String to);
}

