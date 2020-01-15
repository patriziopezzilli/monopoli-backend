package com.ristorantemonopoli.backend.service;

import com.ristorantemonopoli.backend.dto.PastoDTO;

import java.util.List;

public interface MenuDelGiornoService {

    List<PastoDTO> retrievePasti(String categoria);

}
