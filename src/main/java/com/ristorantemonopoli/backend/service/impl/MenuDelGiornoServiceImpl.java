package com.ristorantemonopoli.backend.service.impl;

import com.ristorantemonopoli.backend.database.entity.MenuDelGiorno;
import com.ristorantemonopoli.backend.database.repository.MenuDelGiornoRepository;
import com.ristorantemonopoli.backend.dto.MenuDelGiornoSaveRequest;
import com.ristorantemonopoli.backend.dto.PastoDTO;
import com.ristorantemonopoli.backend.service.MenuDelGiornoService;
import org.apache.commons.lang3.StringUtils;
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

        /**
         * retrieve
         */
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

        /**
         * remove duplicates
         */
        for (int i = 0; i < pastoDTOS.size() - 1; i++) {
            if (pastoDTOS.get(i).getNome().equals(pastoDTOS.get(i + 1).getNome())) {
                pastoDTOS.remove(i);
                i--;
            }
        }

        return pastoDTOS;
    }

    @Override
    public void saveMenuDelGiorno(MenuDelGiornoSaveRequest request) {
        if (null != request) {
            repository.deleteAll();

            if (null != request.getPrimi()) {
                request.getPrimi().forEach(p -> {
                    String capitalizedName = (StringUtils.capitalize(p.getNome()));
                    p.setNome(capitalizedName);
                    repository.save(new MenuDelGiorno(p.getNome(), p.getPrezzo(), p.getCategoria()));
                });
            }

            if (null != request.getSecondi()) {
                request.getSecondi().forEach(p -> {
                    String capitalizedName = (StringUtils.capitalize(p.getNome()));
                    p.setNome(capitalizedName);
                    repository.save(new MenuDelGiorno(p.getNome(), p.getPrezzo(), p.getCategoria()));
                });
            }

            if (null != request.getPizze()) {
                request.getPizze().forEach(p -> {
                    String capitalizedName = (StringUtils.capitalize(p.getNome()));
                    p.setNome(capitalizedName);
                    repository.save(new MenuDelGiorno(p.getNome(), p.getPrezzo(), p.getCategoria()));
                });
            }
        }
    }

    @Override
    public void inviaInStampa() {

    }

    @Override
    public void notificaClienti() {

    }
}