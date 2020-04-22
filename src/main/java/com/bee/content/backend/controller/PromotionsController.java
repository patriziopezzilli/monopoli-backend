package com.bee.content.backend.controller;

import com.bee.content.backend.dto.PromotionDTO;
import com.bee.content.backend.service.PromotionService;
import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bee.content.backend.utils.MerchantUtils.MERCHANT_HEADER_KEY;
import static com.bee.content.backend.utils.MerchantUtils.validateMerchant;

@RestController
public class PromotionsController {

    @Autowired
    private PromotionService promotionService;

    @RequestMapping(value = "/promotions", method = RequestMethod.GET)
    public List<PromotionDTO> getPromotion(@RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        return promotionService.retrievePromotions(ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/promotions/{id}", method = RequestMethod.DELETE)
    public void removePromotion(@PathVariable Long id, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        promotionService.deleteById(id);
    }

    @RequestMapping(value = "/promotions", method = RequestMethod.POST)
    public void createPromotion(@RequestBody PromotionDTO request, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        promotionService.createPromotion(request);
    }

    @RequestMapping(value = "/promotions", method = RequestMethod.PUT)
    public void updatePromotion(@RequestBody PromotionDTO request, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        promotionService.updatePromtion(request);
    }
}
