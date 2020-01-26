package com.ristorantemonopoli.backend.service;

import com.ristorantemonopoli.backend.dto.ConfigDTO;

public interface ConfigService {

    ConfigDTO retrieveDescrizione();

    void inserisciDescrizione(ConfigDTO dto);
}
