package com.ristorantemonopoli.backend.controller;

import com.ristorantemonopoli.backend.dto.PastoDTO;
import com.ristorantemonopoli.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    private List<PastoDTO> pastoDTOList(@RequestParam String categoria) {
        return menuService.retrievePasti(categoria);
    }

    @RequestMapping(value = "/menu/{id}", method = RequestMethod.DELETE)
    private void deleteById(@PathVariable Long id) {
        menuService.deletePasto(id);
    }

    @RequestMapping(value = "/menu/{id}", method = RequestMethod.PUT)
    private void updateById(@PathVariable Long id, @RequestBody PastoDTO aggiornamento) {
        aggiornamento.setId(id);
        menuService.updatePasto(aggiornamento);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    private void create(@RequestBody PastoDTO nuovo) {
        menuService.createPasto(nuovo);
    }
}


