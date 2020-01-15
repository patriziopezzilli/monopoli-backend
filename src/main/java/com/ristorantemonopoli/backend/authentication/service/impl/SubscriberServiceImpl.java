package com.ristorantemonopoli.backend.authentication.service.impl;

import com.ristorantemonopoli.backend.authentication.service.SubscriberService;
import com.ristorantemonopoli.backend.authentication.service.VisitorService;
import com.ristorantemonopoli.backend.database.repository.CourtesySubscriberRepository;
import com.ristorantemonopoli.backend.database.repository.MenuSubscriberRepository;
import com.ristorantemonopoli.backend.database.repository.VisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}