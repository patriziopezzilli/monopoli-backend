package com.bee.content.backend.service;

import com.bee.content.backend.dto.RecensioneDTO;

public interface TripAdvisorService {

    RecensioneDTO retrieveDescrizioneById(Long id, String merchant);

    void saveDescrizioneById(Long id, RecensioneDTO dto, String merchant);
}
