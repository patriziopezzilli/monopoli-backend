package com.ristorantemonopoli.backend.service.impl;

import com.ristorantemonopoli.backend.database.entity.MenuSubscriber;
import com.ristorantemonopoli.backend.database.repository.CourtesySubscriberRepository;
import com.ristorantemonopoli.backend.database.repository.MenuSubscriberRepository;
import com.ristorantemonopoli.backend.dto.SubscriberDTO;
import com.ristorantemonopoli.backend.service.SubscriberService;
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
    public Integer countMenuSubscriber() {
        return (int) menuSubscriberRepository.count();
    }

    @Override
    public Integer countCourtesySubscriber() {
        return (int) courtesySubscriberRepository.count();
    }

    @Override
    public List<SubscriberDTO> menuSubscribers() {
        List<MenuSubscriber> menuSubscribers = menuSubscriberRepository.findAll();
        List<SubscriberDTO> subscriberDTOS = new ArrayList<>();

        menuSubscribers.forEach(c -> subscriberDTOS.add(new SubscriberDTO(c.getEmail())));

        return subscriberDTOS;
    }

    @Override
    public void saveNewSubscriber(String mail) {
        MenuSubscriber newSubscriber = new MenuSubscriber();
        newSubscriber.setEmail(mail);

        menuSubscriberRepository.save(newSubscriber);
    }
}