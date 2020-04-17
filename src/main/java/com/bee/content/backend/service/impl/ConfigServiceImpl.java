package com.bee.content.backend.service.impl;

import com.bee.content.backend.database.entity.ConfigEntity;
import com.bee.content.backend.database.repository.ConfigRepository;
import com.bee.content.backend.dto.ConfigDTO;
import com.bee.content.backend.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigServiceImpl implements ConfigService {
    private final String DESCRIPTION_KEY = "descrizione";

    @Autowired
    private ConfigRepository configRepository;

    @Override
    public ConfigDTO retrieveDescription(String merchant) {
        ConfigEntity configEntity = configRepository.findByNameAndMerchant(DESCRIPTION_KEY, merchant);
        return new ConfigDTO(configEntity.getName(), configEntity.getValue());
    }

    @Override
    public void insertDescription(ConfigDTO dto, String merchant) {
        ConfigEntity configEntity = configRepository.findByNameAndMerchant(DESCRIPTION_KEY, merchant);
        configEntity.setValue(dto.getValue());
        configRepository.save(configEntity);
    }
}
