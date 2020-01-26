package com.ristorantemonopoli.backend.service.impl;

import com.ristorantemonopoli.backend.database.entity.ConfigEntity;
import com.ristorantemonopoli.backend.database.repository.ConfigRepository;
import com.ristorantemonopoli.backend.dto.ConfigDTO;
import com.ristorantemonopoli.backend.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigRepository configRepository;

    @Override
    public ConfigDTO retrieveDescrizione() {
        ConfigEntity configEntity = configRepository.findByName("descrizione");
        return new ConfigDTO(configEntity.getName(), configEntity.getValue());
    }

    @Override
    public void inserisciDescrizione(ConfigDTO dto) {
        ConfigEntity configEntity = configRepository.findByName("descrizione");
        configEntity.setValue(dto.getValue());
        configRepository.save(configEntity);
    }
}
