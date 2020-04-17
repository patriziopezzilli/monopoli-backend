package com.bee.content.backend.service.impl;

import com.bee.content.backend.constants.InternalTemplateUtils;
import com.bee.content.backend.database.entity.MenuDelGiorno;
import com.bee.content.backend.database.entity.MenuDelGiornoData;
import com.bee.content.backend.database.repository.DailyMenuDateRepository;
import com.bee.content.backend.database.repository.DailyMenuRepository;
import com.bee.content.backend.dto.MenuDelGiornoSaveRequest;
import com.bee.content.backend.dto.PastoDTO;
import com.bee.content.backend.dto.SubscriberDTO;
import com.bee.content.backend.service.DailyMenuService;
import com.bee.content.backend.service.MailService;
import com.bee.content.backend.service.SubscriberService;
import com.bee.content.backend.utils.TemplateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class DailyMenuServiceImpl implements DailyMenuService {

    @Autowired
    private DailyMenuRepository repository;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private MailService mailService;

    @Autowired
    private DailyMenuDateRepository dailyMenuDateRepository;

    @Value("classpath:menudelgiorno.txt")
    private Resource resource;

    private String retrieveInternalDailyMenuTemplate() {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public List<PastoDTO> retrievePlates(String categoria, String merchant) {

        /**
         * retrieve
         */
        List<MenuDelGiorno> menuDelGiornos = repository.findByCategoriaAndMerchant(categoria, merchant);

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
    public void saveDailyMenu(MenuDelGiornoSaveRequest request, String merchant) {
        if (null != request) {
            repository.deleteAllByMerchant(merchant);

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
                    repository.save(new MenuDelGiorno(p.getNome(), p.getPrezzo(), p.getCategoria(), merchant));
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
                    repository.save(new MenuDelGiorno(p.getNome(), p.getPrezzo(), p.getCategoria(), merchant));
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
                    repository.save(new MenuDelGiorno(p.getNome(), p.getPrezzo(), p.getCategoria(), merchant));
                });
            }
        }
    }

    @Override
    public void sendToPrint(String merchant) {
        String mail = retrieveInternalDailyMenuTemplate();

        List<PastoDTO> primi = retrievePlates("primo", merchant);
        List<PastoDTO> secondi = retrievePlates("secondo", merchant);
        List<PastoDTO> pizze = retrievePlates("pizza", merchant);

        /**
         * Primi
         */
        if (null != primi && primi.size() > 0) {

            /**
             * Nomi
             */
            String listNomi = "";
            for (String s : primi.stream()
                    .map(PastoDTO::getNome)
                    .collect(Collectors.toList())) {

                listNomi += InternalTemplateUtils.NOME_PLACEHOLDER.replace("#NOME#", s);
            }

            /**
             * Prezzo
             */
            String listPrezzi = "";
            for (String s : primi.stream()
                    .map(PastoDTO::getPrezzo)
                    .collect(Collectors.toList())) {

                listPrezzi += InternalTemplateUtils.PREZZO_PLACEHOLDER.replace("#PREZZO#", s.replace("€", "&euro;"));
            }

            mail = mail.replace(InternalTemplateUtils.LIST_PRIMI_NOMI, listNomi);
            mail = mail.replace(InternalTemplateUtils.LIST_PRIMI_PREZZI, listPrezzi);
        }

        /**
         * Secondi
         */
        if (null != secondi && secondi.size() > 0) {

            /**
             * Nomi
             */
            String listNomi = "";
            for (String s : secondi.stream()
                    .map(PastoDTO::getNome)
                    .collect(Collectors.toList())) {

                listNomi += InternalTemplateUtils.NOME_PLACEHOLDER.replace("#NOME#", s);
            }

            /**
             * Prezzo
             */
            String listPrezzi = "";
            for (String s : secondi.stream()
                    .map(PastoDTO::getPrezzo)
                    .collect(Collectors.toList())) {

                listPrezzi += InternalTemplateUtils.PREZZO_PLACEHOLDER.replace("#PREZZO#", s.replace("€", "&euro;"));
            }

            mail = mail.replace(InternalTemplateUtils.LIST_SECONDI_NOMI, listNomi);
            mail = mail.replace(InternalTemplateUtils.LIST_SECONDI_PREZZI, listPrezzi);
        }

        /**
         * Pizze
         */
        if (null != pizze && pizze.size() > 0) {

            /**
             * Nomi
             */
            String listNomi = "";
            for (String s : pizze.stream()
                    .map(PastoDTO::getNome)
                    .collect(Collectors.toList())) {

                listNomi += InternalTemplateUtils.NOME_PLACEHOLDER.replace("#NOME#", s);
            }

            /**
             * Prezzo
             */
            String listPrezzi = "";
            for (String s : pizze.stream()
                    .map(PastoDTO::getPrezzo)
                    .collect(Collectors.toList())) {

                listPrezzi += InternalTemplateUtils.PREZZO_PLACEHOLDER.replace("#PREZZO#", s.replace("€", "&euro;"));
            }

            mail = mail.replace(InternalTemplateUtils.LIST_PIZZE_NOMI, listNomi);
            mail = mail.replace(InternalTemplateUtils.LIST_PIZZE_PREZZI, listPrezzi);
        }

        try {
            String subject = "Menu del giorno da stampare";
            mailService.sendMailWithAttachment(Arrays.asList("patriziopezzilli@gmail.com"), subject, mail, mail, merchant);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void notifyCustomers(String merchant) {
        String mail = (TemplateUtils.BASE_TEMPLATE_CLIENTI);

        List<PastoDTO> primi = retrievePlates("primo", merchant);
        List<PastoDTO> secondi = retrievePlates("secondo", merchant);
        List<PastoDTO> pizze = retrievePlates("pizza", merchant);

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
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", primi.get(0).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(0).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO1#", contenuto);
        } else {
            mail = mail.replace("#PRIMO1#", "");
        }
        if (2 <= primi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", primi.get(1).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(1).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO2#", contenuto);
        } else {
            mail = mail.replace("#PRIMO2#", "");
        }
        if (3 <= primi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", primi.get(2).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(2).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO3#", contenuto);
        } else {
            mail = mail.replace("#PRIMO3#", "");
        }
        if (4 <= primi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", primi.get(3).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(3).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO4#", contenuto);
        } else {
            mail = mail.replace("#PRIMO4#", "");
        }
        if (5 <= primi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", primi.get(4).getNome());
            contenuto = contenuto.replace("#PREZZO#", primi.get(4).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#PRIMO5#", contenuto);
        } else {
            mail = mail.replace("#PRIMO5#", "");
        }

        /**
         * Replace secondi
         */
        if (1 <= secondi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", secondi.get(0).getNome());
            contenuto = contenuto.replace("#PREZZO#", secondi.get(0).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#SECONDO1#", contenuto);
        } else {
            mail = mail.replace("#SECONDO1#", "");
        }
        if (2 <= secondi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", secondi.get(1).getNome());
            contenuto = contenuto.replace("#PREZZO#", secondi.get(1).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#SECONDO2#", contenuto);
        } else {
            mail = mail.replace("#SECONDO2#", "");
        }
        if (3 <= secondi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", secondi.get(2).getNome());
            contenuto = contenuto.replace("#PREZZO#", secondi.get(2).getPrezzo().replace("€", "&euro;"));
            mail = mail.replace("#SECONDO3#", contenuto);
        } else {
            mail = mail.replace("#SECONDO3#", "");
        }
        if (4 <= secondi.size()) {
            String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", secondi.get(3).getNome());
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
                String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", pizze.get(0).getNome());
                contenuto = contenuto.replace("#PREZZO#", pizze.get(0).getPrezzo().replace("€", "&euro;"));
                mail = mail.replace("#PIZZA1#", contenuto);
            } else {
                mail = mail.replace("#PIZZA1#", "");
            }
            if (2 <= pizze.size()) {
                String contenuto = TemplateUtils.MAIL_DAYMENU_CUSTOMER_TEMPLATE.replace("#NOME#", pizze.get(1).getNome());
                contenuto = contenuto.replace("#PREZZO#", pizze.get(1).getPrezzo().replace("€", "&euro;"));
                mail = mail.replace("#PIZZA2#", contenuto);
            } else {
                mail = mail.replace("#PIZZA2#", "");
            }
        } else {
            mail = mail.replace("PRESENZAPIZZE", "display:none;");
        }

        MenuDelGiornoData data = dailyMenuDateRepository.getByMerchant(merchant);
        data.setValore(dataStr);
        data.setMerchant(merchant);
        dailyMenuDateRepository.save(data);

        try {
            // Recipient's email ID needs to be mentioned.
            List<SubscriberDTO> subscriberDTOS = subscriberService.menuSubscribers(merchant);
            String subject = "Menu del giorno " + dataStr;

            mailService.sendMail(subscriberDTOS.stream().map(SubscriberDTO::getMail).collect(Collectors.toList()), subject, mail, merchant);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}