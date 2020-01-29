package com.ristorantemonopoli.backend.controller;

import com.ristorantemonopoli.backend.dto.PastoDTO;
import com.ristorantemonopoli.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    private List<PastoDTO> pastoDTOList(@RequestParam String categoria) {
        return menuService.retrievePasti(categoria);
    }
}
