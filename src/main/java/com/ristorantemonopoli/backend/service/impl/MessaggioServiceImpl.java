package com.ristorantemonopoli.backend.service.impl;

import com.ristorantemonopoli.backend.database.entity.Messaggio;
import com.ristorantemonopoli.backend.database.repository.MessaggioRepository;
import com.ristorantemonopoli.backend.dto.MessaggioDTO;
import com.ristorantemonopoli.backend.service.MailService;
import com.ristorantemonopoli.backend.service.MessaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.ristorantemonopoli.backend.utils.TemplateUtils.MAIL_MESSAGE_RESPONSE_TEMPLATE;

@Service
public class MessaggioServiceImpl implements MessaggioService {

    @Autowired
    private MailService mailService;

    @Autowired
    private MessaggioRepository repository;

    @Override
    public void sendRisposta(Long messaggioId, String risposta) throws Exception {
        Messaggio messaggio = repository.getOne(messaggioId);

        // add template
        if (null != messaggio && null != messaggio.getMail()) {
            String mailContent = MAIL_MESSAGE_RESPONSE_TEMPLATE.replace("#NOME#", messaggio.getNome().toUpperCase());
            mailContent = mailContent.replace("#DOMANDA#", messaggio.getMessaggio());
            mailContent = mailContent.replace("#RISPOSTA", risposta);

            mailService.sendMail(Arrays.asList(messaggio.getMail()), "Risposta del Ristorante", mailContent);
        }
    }

    @Override
    public List<MessaggioDTO> retrieveMessaggi() {
        List<Messaggio> messaggios = repository.findAll();
        List<MessaggioDTO> response = new ArrayList<>();

        messaggios.forEach(c -> response.add(
                new MessaggioDTO(
                        c.getId(),
                        c.getNome(),
                        c.getMail(),
                        c.getMessaggio(),
                        c.getRisposto()
                )
        ));
        return response;
    }
}
