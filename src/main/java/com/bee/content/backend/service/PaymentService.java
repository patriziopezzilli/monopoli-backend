package com.bee.content.backend.service;

import com.bee.content.backend.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    List<PaymentDTO> retrievePayments(String email, String merchant);
}
