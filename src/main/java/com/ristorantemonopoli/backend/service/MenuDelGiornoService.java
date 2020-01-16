package com.ristorantemonopoli.backend.service;

import com.ristorantemonopoli.backend.dto.MenuDelGiornoSaveRequest;
import com.ristorantemonopoli.backend.dto.PastoDTO;

import java.util.List;

public interface MenuDelGiornoService {

    List<PastoDTO> retrievePasti(String categoria);

    void saveMenuDelGiorno(MenuDelGiornoSaveRequest request);

    void inviaInStampa();

    void notificaClienti();
}
