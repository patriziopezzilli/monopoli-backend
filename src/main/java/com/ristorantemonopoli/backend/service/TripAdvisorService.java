package com.ristorantemonopoli.backend.service;

import com.ristorantemonopoli.backend.dto.RecensioneDTO;

public interface TripAdvisorService {

    RecensioneDTO retrieveDescrizioneById(Long id);

    void saveDescrizioneById(Long id, RecensioneDTO dto);
}
