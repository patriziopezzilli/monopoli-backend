package com.bee.content.backend.service;

import com.bee.content.backend.database.entity.Payment;
import com.bee.content.backend.database.repository.PaymentRepository;
import com.bee.content.backend.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentDTO> retrievePayments(String email, String merchant) {
        List<PaymentDTO> response = new ArrayList<>();
        List<Payment> payments = paymentRepository.findByMerchantAndEmail(merchant, email);

        // iterate over and populate
        if (null != payments) {
            payments.forEach(c -> {
                response.add(new PaymentDTO(
                        c.getEmail(),
                        c.getMerchant(),
                        c.getName(),
                        c.getDescription(),
                        c.getPlan(),
                        c.getAmount(),
                        c.getPaid(),
                        c.getExternalId()
                ));
            });
        }

        return response;
    }
}
