package com.bee.content.backend.service.impl;

import com.bee.content.backend.database.entity.Promotion;
import com.bee.content.backend.database.repository.PromotionRepository;
import com.bee.content.backend.dto.PromotionDTO;
import com.bee.content.backend.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public void deleteById(Long id) {
        promotionRepository.deleteById(id);
    }

    @Override
    public List<PromotionDTO> retrievePromotions(String merchant) {
        List<PromotionDTO> response = new ArrayList<>();
        List<Promotion> promotions = promotionRepository.findByMerchant(merchant);

        if (null != promotions) {
            promotions.forEach(c -> {
                response.add(new PromotionDTO(
                        c.getId(),
                        c.getFormat(),
                        c.getName(),
                        c.getContent(),
                        c.getExtraInfo(),
                        c.getType(),
                        c.getMerchant()
                ));
            });
        }

        return response;
    }

    @Override
    public void createPromotion(PromotionDTO promotion) {
        Promotion newPromotion = new Promotion();

        newPromotion.setContent(promotion.getContent());
        newPromotion.setExtraInfo(promotion.getExtraInfo());
        newPromotion.setFormat(promotion.getFormat());
        newPromotion.setMerchant(promotion.getMerchant());
        newPromotion.setName(promotion.getName());
        newPromotion.setType(promotion.getType());

        promotionRepository.save(newPromotion);
    }

    @Override
    public void updatePromtion(PromotionDTO promotion) {
        Promotion newPromotion = promotionRepository.getOne(promotion.getId());

        newPromotion.setContent(promotion.getContent());
        newPromotion.setExtraInfo(promotion.getExtraInfo());
        newPromotion.setFormat(promotion.getFormat());
        newPromotion.setMerchant(promotion.getMerchant());
        newPromotion.setName(promotion.getName());
        newPromotion.setType(promotion.getType());

        promotionRepository.save(newPromotion);
    }
}
