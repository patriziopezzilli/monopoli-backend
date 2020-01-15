package com.ristorantemonopoli.backend.controller;

import com.ristorantemonopoli.backend.dto.PastoDTO;
import com.ristorantemonopoli.backend.dto.SubscriberDTO;
import com.ristorantemonopoli.backend.service.MenuDelGiornoService;
import com.ristorantemonopoli.backend.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuDelGiornoController {

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private MenuDelGiornoService menuDelGiornoService;

    @RequestMapping(value = "/menudelgiorno/sottoscritti", method = RequestMethod.GET)
    public List<SubscriberDTO> subscriberList() {
        return subscriberService.menuSubscribers();
    }

    @RequestMapping(value = "/menudelgiorno", method = RequestMethod.GET)
    private List<PastoDTO> pastoDTOList(@RequestParam String categoria) {
        return menuDelGiornoService.retrievePasti(categoria);
    }
}
