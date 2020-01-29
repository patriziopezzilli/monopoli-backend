package com.ristorantemonopoli.backend.service;

import com.ristorantemonopoli.backend.dto.MenuDelGiornoSaveRequest;
import com.ristorantemonopoli.backend.dto.PastoDTO;

import java.util.List;

public interface MenuService {

    List<PastoDTO> retrievePasti(String categoria);

    void createPasto(PastoDTO pasto);

    void deletePasto(Long id);

    void updatePasto(PastoDTO pasto);
}
