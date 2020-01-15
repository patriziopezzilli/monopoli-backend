package com.ristorantemonopoli.backend.service.impl;

import com.ristorantemonopoli.backend.database.entity.MenuDelGiorno;
import com.ristorantemonopoli.backend.database.repository.MenuDelGiornoRepository;
import com.ristorantemonopoli.backend.database.repository.VisiteRepository;
import com.ristorantemonopoli.backend.dto.PastoDTO;
import com.ristorantemonopoli.backend.service.MenuDelGiornoService;
import com.ristorantemonopoli.backend.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuDelGiornoServiceImpl implements MenuDelGiornoService {

    @Autowired
    private MenuDelGiornoRepository repository;

    @Override
    public List<PastoDTO> retrievePasti(String categoria) {
        List<MenuDelGiorno> menuDelGiornos = repository.findByCategoria(categoria);
        List<PastoDTO> pastoDTOS = new ArrayList<>();

        menuDelGiornos.forEach(c -> pastoDTOS.add(
                new PastoDTO(
                        c.getNome(),
                        null,
                        c.getPrezzo(),
                        c.getCategoria()
                )
        ));

        return pastoDTOS;
    }
}