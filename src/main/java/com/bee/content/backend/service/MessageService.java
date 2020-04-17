package com.bee.content.backend.service;

import com.bee.content.backend.dto.MessaggioDTO;

import java.util.List;

public interface MessageService {

    void sendRisposta(Long messaggioId, String risposta, String merchant) throws Exception;

    List<MessaggioDTO> retrieveMessaggi(String merchant);
}
