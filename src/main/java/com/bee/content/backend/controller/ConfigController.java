package com.bee.content.backend.controller;

import com.bee.content.backend.dto.ConfigDTO;
import com.bee.content.backend.service.ConfigService;
import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @RequestMapping(value = "/config/description", method = RequestMethod.POST)
    public void saveDescription(@RequestBody ConfigDTO request) {
        configService.insertDescription(request, ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/config/description", method = RequestMethod.GET)
    public ConfigDTO getDescription() {
        return configService.retrieveDescription(ThreadState.INSTANCE.getMerchant());
    }
}
