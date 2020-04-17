package com.bee.content.backend.controller;

import com.bee.content.backend.dto.ConfigDTO;
import com.bee.content.backend.service.ConfigService;
import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.bee.content.backend.utils.MerchantUtils.MERCHANT_HEADER_KEY;
import static com.bee.content.backend.utils.MerchantUtils.validateMerchant;

@RestController
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @RequestMapping(value = "/config/description", method = RequestMethod.POST)
    public void saveDescription(@RequestBody ConfigDTO request, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        configService.insertDescription(request, ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/config/description", method = RequestMethod.GET)
    public ConfigDTO getDescription(@RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        return configService.retrieveDescription(ThreadState.INSTANCE.getMerchant());
    }
}
