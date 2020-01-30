package com.ristorantemonopoli.backend.service;

import com.ristorantemonopoli.backend.dto.MessaggioDTO;

import java.util.List;

public interface MessaggioService {

    void sendRisposta(Long messaggioId, String risposta) throws Exception;

    List<MessaggioDTO> retrieveMessaggi();
}
