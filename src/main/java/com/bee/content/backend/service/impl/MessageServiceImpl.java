package com.bee.content.backend.service.impl;

import com.bee.content.backend.database.entity.Messaggio;
import com.bee.content.backend.database.repository.MessaggioRepository;
import com.bee.content.backend.dto.MessaggioDTO;
import com.bee.content.backend.service.MailService;
import com.bee.content.backend.service.MessageService;
import com.bee.content.backend.utils.TemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MailService mailService;

    @Autowired
    private MessaggioRepository repository;

    @Override
    public void sendRisposta(Long messaggioId, String risposta, String merchant) throws Exception {
        Messaggio messaggio = repository.getOne(messaggioId);

        // add template
        if (null != messaggio && null != messaggio.getMail()) {
            String mailContent = TemplateUtils.MAIL_MESSAGE_RESPONSE_TEMPLATE.replace("#NOME#", messaggio.getNome().toUpperCase());
            mailContent = mailContent.replace("#DOMANDA#", messaggio.getMessaggio());
            mailContent = mailContent.replace("#RISPOSTA#", risposta);

            mailService.sendMail(Arrays.asList(messaggio.getMail()), "Risposta del Ristorante", mailContent, merchant);

            messaggio.setRisposto(1);
            messaggio.setMerchant(merchant);
            repository.save(messaggio);
        }
    }

    @Override
    public List<MessaggioDTO> retrieveMessaggi(String merchant) {
        List<Messaggio> messaggios = repository.findByMerchant(merchant);
        List<MessaggioDTO> response = new ArrayList<>();

        messaggios.forEach(c -> {
            if (c.getRisposto() != 1) {

                response.add(
                        new MessaggioDTO(
                                c.getId(),
                                c.getNome(),
                                c.getMail(),
                                c.getMessaggio(),
                                c.getRisposto()
                        ));
            }
        });
        return response;
    }
}
