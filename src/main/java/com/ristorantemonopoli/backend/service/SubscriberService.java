package com.ristorantemonopoli.backend.service;

import com.ristorantemonopoli.backend.dto.SubscriberDTO;

import java.util.List;

public interface SubscriberService {

    Integer countMenuSubscriber();

    Integer countCourtesySubscriber();

    List<SubscriberDTO> menuSubscribers();

    void saveNewSubscriber(String mail);
}
