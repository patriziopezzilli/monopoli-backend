package com.ristorantemonopoli.backend.service.impl;

import com.ristorantemonopoli.backend.database.entity.RecensioneEntity;
import com.ristorantemonopoli.backend.database.repository.RecensioneRepository;
import com.ristorantemonopoli.backend.dto.RecensioneDTO;
import com.ristorantemonopoli.backend.service.TripAdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripAdvisorServiceImpl implements TripAdvisorService {

    @Autowired
    private RecensioneRepository recensioneRepository;

    @Override
    public RecensioneDTO retrieveDescrizioneById(Long id) {
        RecensioneEntity entity = recensioneRepository.getOne(id);
        return new RecensioneDTO(entity.getReview(), entity.getAuthor());
    }

    @Override
    public void saveDescrizioneById(Long id, RecensioneDTO dto) {
        RecensioneEntity entity = recensioneRepository.getOne(id);
        entity.setReview(dto.getContenuto());
        entity.setAuthor(dto.getAutore());
        recensioneRepository.save(entity);
    }
}
