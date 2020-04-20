package com.bee.content.backend.controller;

import com.bee.content.backend.dto.PaymentDTO;
import com.bee.content.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bee.content.backend.utils.MerchantUtils.MERCHANT_HEADER_KEY;
import static com.bee.content.backend.utils.MerchantUtils.validateMerchant;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/payments", method = RequestMethod.GET)
    public List<PaymentDTO> getMessages(@RequestParam String email, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        return paymentService.retrievePayments(email, merchant);
    }
}
