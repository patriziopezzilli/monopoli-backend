package com.bee.content.backend.service.impl;

import com.bee.content.backend.database.entity.Menu;
import com.bee.content.backend.database.repository.MenuRepository;
import com.bee.content.backend.dto.PastoDTO;
import com.bee.content.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public List<PastoDTO> retrievePasti(String categoria, String merchant) {

        /**
         * retrieve
         */
        List<Menu> menuDelGiornos = repository.findByCategoriaAndMerchant(categoria, merchant);

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
    public void createPasto(PastoDTO pasto, String merchant) {
        if (pasto.getPrezzo() != null && pasto.getPrezzo().contains("€")) {
            pasto.setPrezzo(pasto.getPrezzo().replace("€", ""));
        }

        Menu menu = new Menu();
        menu.setNome(pasto.getNome());
        menu.setDescrizione(pasto.getDescrizione());
        menu.setPrezzo(pasto.getPrezzo());
        menu.setCategoria(pasto.getCategoria());
        menu.setMerchant(merchant);

        repository.save(menu);
    }

    @Override
    public void deletePasto(Long id, String merchant) {
        repository.deleteByIdAndMerchant(id, merchant);
    }

    @Override
    public void updatePasto(PastoDTO pasto, String merchant) {
        Menu found = repository.getOne(pasto.getId());

        if (pasto.getPrezzo() != null && pasto.getPrezzo().contains("€")) {
            pasto.setPrezzo(pasto.getPrezzo().replace("€", ""));
        }

        if (null != found) {
            found.setNome(pasto.getNome());
            found.setDescrizione(pasto.getDescrizione());
            found.setPrezzo(pasto.getPrezzo());
            found.setCategoria(pasto.getCategoria());

            repository.save(found);
        }
    }
}