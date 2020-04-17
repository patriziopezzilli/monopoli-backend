package com.bee.content.backend.controller;

import com.bee.content.backend.dto.MenuDelGiornoSaveRequest;
import com.bee.content.backend.dto.PastoDTO;
import com.bee.content.backend.dto.SubscriberDTO;
import com.bee.content.backend.service.DailyMenuService;
import com.bee.content.backend.service.SubscriberService;
import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DailyMenuController {

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private DailyMenuService dailyMenuService;

    @RequestMapping(value = "/dailymenu/subscribers", method = RequestMethod.GET)
    public List<SubscriberDTO> subscriberList() {
        return subscriberService.menuSubscribers(ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/dailymenu/subscribers", method = RequestMethod.POST)
    public void subscriberList(@RequestParam String email) {
        subscriberService.saveNewSubscriber(email, ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/dailymenu", method = RequestMethod.GET)
    private List<PastoDTO> retrievePlates(@RequestParam String categoria) {
        return dailyMenuService.retrievePlates(categoria, ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/dailymenu/print", method = RequestMethod.GET)
    private void stampa() {
        dailyMenuService.sendToPrint(ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/dailymenu/mail", method = RequestMethod.GET)
    private void inviaViaMail() {
        dailyMenuService.notifyCustomers(ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/dailymenu", method = RequestMethod.POST)
    private void saveMenuDelGiorno(@RequestBody MenuDelGiornoSaveRequest request) {
        dailyMenuService.saveDailyMenu(request, ThreadState.INSTANCE.getMerchant());
    }
}
