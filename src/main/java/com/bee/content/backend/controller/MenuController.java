package com.bee.content.backend.controller;

import com.bee.content.backend.dto.PastoDTO;
import com.bee.content.backend.service.MenuService;
import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bee.content.backend.utils.MerchantUtils.MERCHANT_HEADER_KEY;
import static com.bee.content.backend.utils.MerchantUtils.validateMerchant;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    private List<PastoDTO> retrieveMenu(@RequestParam String categoria, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        return menuService.retrievePasti(categoria, ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/menu/{id}", method = RequestMethod.DELETE)
    private void deleteById(@PathVariable Long id, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        menuService.deletePasto(id, ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/menu/{id}", method = RequestMethod.PUT)
    private void updateById(@PathVariable Long id, @RequestBody PastoDTO aggiornamento, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        aggiornamento.setId(id);
        menuService.updatePasto(aggiornamento, ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    private void create(@RequestBody PastoDTO nuovo, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        menuService.createPasto(nuovo, ThreadState.INSTANCE.getMerchant());
    }
}


