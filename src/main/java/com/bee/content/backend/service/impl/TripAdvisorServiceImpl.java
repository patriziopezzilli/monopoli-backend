package com.bee.content.backend.service.impl;

import com.bee.content.backend.database.repository.RecensioneRepository;
import com.bee.content.backend.dto.RecensioneDTO;
import com.bee.content.backend.service.TripAdvisorService;
import com.bee.content.backend.database.entity.RecensioneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripAdvisorServiceImpl implements TripAdvisorService {

    @Autowired
    private RecensioneRepository recensioneRepository;

    @Override
    public RecensioneDTO retrieveDescrizioneById(Long id, String merchant) {
        RecensioneEntity entity = recensioneRepository.getOne(id);
        return new RecensioneDTO(entity.getReview(), entity.getAuthor());
    }

    @Override
    public void saveDescrizioneById(Long id, RecensioneDTO dto, String merchant) {
        RecensioneEntity entity = recensioneRepository.getOne(id);
        entity.setReview(dto.getContenuto());
        entity.setAuthor(dto.getAutore());
        recensioneRepository.save(entity);
    }
}
