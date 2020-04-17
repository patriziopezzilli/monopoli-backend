package com.bee.content.backend.service;

import com.bee.content.backend.dto.PastoDTO;

import java.util.List;

public interface MenuService {

    List<PastoDTO> retrievePasti(String categoria, String merchant);

    void createPasto(PastoDTO pasto, String merchant);

    void deletePasto(Long id, String merchant);

    void updatePasto(PastoDTO pasto, String merchant);
}
