package com.bee.content.backend.controller;

import com.bee.content.backend.dto.PortalMenuDTO;
import com.bee.content.backend.service.PortalMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bee.content.backend.utils.MerchantUtils.MERCHANT_HEADER_KEY;
import static com.bee.content.backend.utils.MerchantUtils.validateMerchant;

@RestController
public class PortalMenuController {

    @Autowired
    private PortalMenuService portalMenuService;

    @RequestMapping(value = "/portal/menu", method = RequestMethod.GET)
    public List<PortalMenuDTO> getPortalMenu(@RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        return portalMenuService.retrievePortalMenu();
    }
}
