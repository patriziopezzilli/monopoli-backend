package com.ristorantemonopoli.backend.service.impl;

import com.ristorantemonopoli.backend.database.entity.Menu;
import com.ristorantemonopoli.backend.database.repository.MenuRepository;
import com.ristorantemonopoli.backend.dto.PastoDTO;
import com.ristorantemonopoli.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public List<PastoDTO> retrievePasti(String categoria) {

        /**
         * retrieve
         */
        List<Menu> menuDelGiornos = repository.findByCategoria(categoria);

        List<PastoDTO> pastoDTOS = new ArrayList<>();

        if (menuDelGiornos != null) {
            menuDelGiornos.forEach(c -> pastoDTOS.add(
                    new PastoDTO(
                            c.getId(),
                            c.getNome(),
                            c.getDescrizione(),
                            c.getPrezzo() + "€",
                            c.getCategoria()
                    )
            ));
        }

        /**
         * remove duplicates
         */
        ArrayList<PastoDTO> newList = new ArrayList<>();
        for (PastoDTO element : pastoDTOS) {
            boolean alreadyPresent = false;

            for (PastoDTO pastoDTO : newList) {
                if (pastoDTO.getNome().equals(element.getNome()) && pastoDTO.getCategoria().equals(element.getCategoria())) {
                    alreadyPresent = true;
                }
            }

            if (!alreadyPresent) {
                newList.add(element);
            }
        }

        return newList;
    }

    @Override
    public void createPasto(PastoDTO pasto) {
        Menu menu = new Menu();
        menu.setNome(pasto.getNome());
        menu.setDescrizione(pasto.getDescrizione());
        menu.setPrezzo(pasto.getPrezzo());
        menu.setCategoria(pasto.getCategoria());

        repository.save(menu);
    }

    @Override
    public void deletePasto(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updatePasto(PastoDTO pasto) {
        Menu found = repository.getOne(pasto.getId());

        if (null != found) {
            found.setNome(pasto.getNome());
            found.setDescrizione(pasto.getDescrizione());
            found.setPrezzo(pasto.getPrezzo());
            found.setCategoria(pasto.getCategoria());

            repository.save(found);
        }
    }
}