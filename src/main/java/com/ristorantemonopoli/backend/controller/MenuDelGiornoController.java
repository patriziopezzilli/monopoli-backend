package com.ristorantemonopoli.backend.controller;

import com.ristorantemonopoli.backend.dto.ProgressDTO;
import com.ristorantemonopoli.backend.dto.SubscriberDTO;
import com.ristorantemonopoli.backend.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuDelGiornoController {

    @Autowired
    private SubscriberService subscriberService;

    @RequestMapping(value = "/menudelgiorno/sottoscritti", method = RequestMethod.GET)
    public List<SubscriberDTO> subscriberList() {
        return subscriberService.menuSubscribers();
    }
}
