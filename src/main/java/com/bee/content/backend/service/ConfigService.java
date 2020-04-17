package com.bee.content.backend.service;

import com.bee.content.backend.dto.ConfigDTO;

public interface ConfigService {

    ConfigDTO retrieveDescription(String merchant);

    void insertDescription(ConfigDTO dto, String merchant);
}
