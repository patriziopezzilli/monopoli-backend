package com.bee.content.backend.service;

import com.bee.content.backend.dto.SubscriberDTO;

import java.util.List;

public interface SubscriberService {

    Integer countMenuSubscriber(String merchant);

    Integer countCourtesySubscriber(String merchant);

    List<SubscriberDTO> menuSubscribers(String merchant);

    void saveNewSubscriber(String mail, String merchant);
}
