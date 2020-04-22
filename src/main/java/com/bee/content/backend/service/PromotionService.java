package com.bee.content.backend.service;

import com.bee.content.backend.dto.PromotionDTO;

import java.util.List;

public interface PromotionService {

    void deleteById(Long id);

    List<PromotionDTO> retrievePromotions(String merchant);

    void createPromotion(PromotionDTO promotion);

    void updatePromtion(PromotionDTO promotion);

}
