package com.bee.content.backend.database.repository;

import com.bee.content.backend.database.entity.ChatMessage;
import com.bee.content.backend.database.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

    List<Payment> findByMerchantAndEmailOrderByIdDesc(String merchant, String email);
}

