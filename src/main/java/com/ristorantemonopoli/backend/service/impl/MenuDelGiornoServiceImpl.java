package com.ristorantemonopoli.backend.service.impl;

import com.ristorantemonopoli.backend.database.entity.MenuDelGiorno;
import com.ristorantemonopoli.backend.database.entity.MenuDelGiornoData;
import com.ristorantemonopoli.backend.database.repository.MenuDelGiornoDataRepository;
import com.ristorantemonopoli.backend.database.repository.MenuDelGiornoRepository;
import com.ristorantemonopoli.backend.dto.MenuDelGiornoSaveRequest;
import com.ristorantemonopoli.backend.dto.PastoDTO;
import com.ristorantemonopoli.backend.dto.SubscriberDTO;
import com.ristorantemonopoli.backend.service.MailService;
import com.ristorantemonopoli.backend.service.MenuDelGiornoService;
import com.ristorantemonopoli.backend.service.SubscriberService;
import com.ristorantemonopoli.backend.utils.TemplateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuDelGiornoServiceImpl implements MenuDelGiornoService {

    @Autowired
    private MenuDelGiornoRepository repository;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private MailService mailService;

    @Autowired
    private MenuDelGiornoDataRepository menuDelGiornoDataRepository;

    @Override
    public List<PastoDTO> retrievePasti(String categoria) {

        /**
         * retrieve
         */
        List<MenuDelGiorno> menuDelGiornos = repository.findByCategoria(categoria);

        List<PastoDTO> pastoDTOS = new ArrayList<>();

        if (menuDelGiornos != null) {
            menuDelGiornos.forEach(c -> pastoDTOS.add(
                    new PastoDTO(
                            c.getNome(),
                            null,
                            c.getPrezzo() + "€",
                            c.getCategoria()
                    )
            ));
        }

        /**
         * remove duplicates
         */
        ArrayList<PastoDTO> newList = new ArrayList<>();
        for (PastoDTO element : pastoDTOS) {
            boolean alreadyPresent = false;

            for (PastoDTO pastoDTO : newList) {
                if (pastoDTO.getNome().equals(element.getNome()) && pastoDTO.getCategoria().equals(element.getCategoria())) {
                    alreadyPresent = true;
                }
            }

            if (!alreadyPresent) {
                newList.add(element);
            }
        }

        return newList;
    }

    @Override
    public void saveMenuDelGiorno(MenuDelGiornoSaveRequest request) {
        if (null != request) {
            repository.deleteAll();

            if (null != request.getPrimi()) {
                request.getPrimi().forEach(p -> {
                    String capitalizedName = (StringUtils.capitalize(p.getNome()));
                    p.setNome(capitalizedName);

                    if (p.getPrezzo().contains(",")) {
                        p.setPrezzo(p.getPrezzo().replace(",", "."));
                        p.setPrezzo(p.getPrezzo().replace("€", ""));
                    } else if (p.getPrezzo().contains(".")) {
                        // nothing
                    } else {
                        p.setPrezzo(p.getPrezzo() + ".00");
                    }
                    repository.save(new MenuDelGiorno(p.getNome(), p.getPrezzo(), p.getCategoria()));
                });
            }

            if (null != request.getSecondi()) {
                request.getSecondi().forEach(p -> {
                    String capitalizedName = (StringUtils.capitalize(p.getNome()));
                    p.setNome(capitalizedName);

                    if (p.getPrezzo().contains(",")) {
                        p.setPrezzo(p.getPrezzo().replace(",", "."));
                        p.setPrezzo(p.getPrezzo().replace("€", ""));
                    } else if (p.getPrezzo().contains(".")) {
                        // nothing
                    } else {
                        p.setPrezzo(p.getPrezzo() + ".00");
                    }
                    repository.save(new MenuDelGiorno(p.getNome(), p.getPrezzo(), p.getCategoria()));
                });
            }

            if (null != request.getPizze()) {
                request.getPizze().forEach(p -> {
                    String capitalizedName = (StringUtils.capitalize(p.getNome()));
                    p.setNome(capitalizedName);

                    if (p.getPrezzo().contains(",")) {
                        p.setPrezzo(p.getPrezzo().replace(",", "."));
                        p.setPrezzo(p.getPrezzo().replace("€", ""));
                    } else if (p.getPrezzo().contains(".")) {
                        // nothing
                    } else {
                        p.setPrezzo(p.getPrezzo() + ".00");
                    }
                    repository.save(new MenuDelGiorno(p.getNome(), p.getPrezzo(), p.getCategoria()));
                });
            }
        }
    }

    @Override
    public void inviaInStampa() {

    }

    @Override
    public void notificaClienti() {
        String mail = (TemplateUtils.BASE_TEMPLATE_CLIENTI);

        List<PastoDTO> primi = retrievePasti("primo");
        List<PastoDTO> secondi = retrievePasti("secondo");
        List<PastoDTO> pizze = retrievePasti("pizza");

        /**
         * Replace date
         */
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatter.format(date);
        mail = mail.replace("#DATA", dataStr);

        /**
         * Replace primi
         */
        if (1 <= primi.size()) {
            String contenuto = TemplateUtils.ENTRY_REPLACEMENT.replace("#NOME#", primi.get(0).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(0).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO1#", contenuto);
        } else {
            mail = mail.replace("#PRIMO1#", "");
        }
        if (2 <= primi.size()) {
            String contenuto = TemplateUtils.ENTRY_REPLACEMENT.replace("#NOME#", primi.get(1).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(1).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO2#", contenuto);
        } else {
            mail = mail.replace("#PRIMO2#", "");
        }
        if (3 <= primi.size()) {
            String contenuto = TemplateUtils.ENTRY_REPLACEMENT.replace("#NOME#", primi.get(2).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(2).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO3#", contenuto);
        } else {
            mail = mail.replace("#PRIMO3#", "");
        }
        if (4 <= primi.size()) {
            String contenuto = TemplateUtils.ENTRY_REPLACEMENT.replace("#NOME#", primi.get(3).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(3).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO4#", contenuto);
        } else {
            mail = mail.replace("#PRIMO4#", "");
        }
        if (5 <= primi.size()) {
            String contenuto = TemplateUtils.ENTRY_REPLACEMENT.replace("#NOME#", primi.get(4).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(4).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO5#", contenuto);
        } else {
            mail = mail.replace("#PRIMO5#", "");
        }

        /**
         * Replace secondi
         */
        if (1 <= secondi.size()) {
            String contenuto = TemplateUtils.ENTRY_REPLACEMENT.replace("#NOME#", secondi.get(0).getNome());
            contenuto = contenuto.replace("#PREZZO#", secondi.get(0).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#SECONDO1#", contenuto);
        } else {
            mail = mail.replace("#SECONDO1#", "");
        }
        if (2 <= secondi.size()) {
            String contenuto = TemplateUtils.ENTRY_REPLACEMENT.replace("#NOME#", secondi.get(1).getNome());
            contenuto = contenuto.replace("#PREZZO#", secondi.get(1).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#SECONDO2#", contenuto);
        } else {
            mail = mail.replace("#SECONDO2#", "");
        }
        if (3 <= secondi.size()) {
            String contenuto = TemplateUtils.ENTRY_REPLACEMENT.replace("#NOME#", secondi.get(2).getNome());
            contenuto = contenuto.replace("#PREZZO#", secondi.get(2).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#SECONDO3#", contenuto);
        } else {
            mail = mail.replace("#SECONDO3#", "");
        }
        if (4 <= secondi.size()) {
            String contenuto = TemplateUtils.ENTRY_REPLACEMENT.replace("#NOME#", secondi.get(3).getNome());
            contenuto = contenuto.replace("#PREZZO#", secondi.get(3).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#SECONDO4#", contenuto);
        } else {
            mail = mail.replace("#SECONDO4#", "");
        }

        /**
         * Check pizza
         */
        if (null != pizze && !pizze.isEmpty()) {
            mail = mail.replace("PRESENZAPIZZE", "");


            /**
             * Replace pizza
             */
            if (1 <= pizze.size()) {
                String contenuto = TemplateUtils.ENTRY_REPLACEMENT.replace("#NOME#", pizze.get(0).getNome());
                contenuto = contenuto.replace("#PREZZO#", pizze.get(0).getPrezzo().replace("€", "&euro;"));
                mail = mail.replace("#PIZZA1#", contenuto);
            } else {
                mail = mail.replace("#PIZZA1#", "");
            }
            if (2 <= pizze.size()) {
                String contenuto = TemplateUtils.ENTRY_REPLACEMENT.replace("#NOME#", pizze.get(1).getNome());
                contenuto = contenuto.replace("#PREZZO#", pizze.get(1).getPrezzo().replace("€", "&euro;"));
                mail = mail.replace("#PIZZA2#", contenuto);
            } else {
                mail = mail.replace("#PIZZA2#", "");
            }
        } else {
            mail = mail.replace("PRESENZAPIZZE", "display:none;");
        }

        MenuDelGiornoData data = menuDelGiornoDataRepository.getOne(1L);
        data.setValore(dataStr);
        menuDelGiornoDataRepository.save(data);

        try {
            // Recipient's email ID needs to be mentioned.
            List<SubscriberDTO> subscriberDTOS = subscriberService.menuSubscribers();
            String subject = "Menu del giorno " + dataStr;

            mailService.sendMail(subscriberDTOS.stream().map(SubscriberDTO::getMail).collect(Collectors.toList()), subject, mail);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}