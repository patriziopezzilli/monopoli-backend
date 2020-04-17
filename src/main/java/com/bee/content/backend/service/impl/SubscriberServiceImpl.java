package com.bee.content.backend.service.impl;

import com.bee.content.backend.database.entity.MenuSubscriber;
import com.bee.content.backend.database.repository.CourtesySubscriberRepository;
import com.bee.content.backend.database.repository.MenuSubscriberRepository;
import com.bee.content.backend.dto.SubscriberDTO;
import com.bee.content.backend.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private CourtesySubscriberRepository courtesySubscriberRepository;

    @Autowired
    private MenuSubscriberRepository menuSubscriberRepository;

    @Override
    public Integer countMenuSubscriber(String merchant) {
        return menuSubscriberRepository.countByMerchant(merchant);
    }

    @Override
    public Integer countCourtesySubscriber(String merchant) {
        return courtesySubscriberRepository.countByMerchant(merchant);
    }

    @Override
    public List<SubscriberDTO> menuSubscribers(String merchant) {
        List<MenuSubscriber> menuSubscribers = menuSubscriberRepository.findByMerchant(merchant);
        List<SubscriberDTO> subscriberDTOS = new ArrayList<>();

        menuSubscribers.forEach(c -> subscriberDTOS.add(new SubscriberDTO(c.getEmail())));

        return subscriberDTOS;
    }

    @Override
    public void saveNewSubscriber(String mail, String merchant) {
        MenuSubscriber newSubscriber = new MenuSubscriber();
        newSubscriber.setEmail(mail);
        newSubscriber.setMerchant(merchant);

        menuSubscriberRepository.save(newSubscriber);
    }
}